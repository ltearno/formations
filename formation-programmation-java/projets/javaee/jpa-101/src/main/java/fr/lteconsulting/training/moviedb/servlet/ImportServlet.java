package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.model.Fabricant;
import fr.lteconsulting.training.moviedb.model.Produit;
import fr.lteconsulting.training.moviedb.outil.Session;
import fr.lteconsulting.training.moviedb.outil.Vues;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@WebServlet("/importation")
@MultipartConfig
public class ImportServlet extends HttpServlet {
    @EJB
    private GestionCategories gestionCategories;

    @EJB
    private GestionFabricants gestionFabricants;

    @EJB
    private GestionProduits gestionProduits;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Session.estConnecte(request)) {
            response.sendRedirect("login");
            return;
        }

        String message = importationExcel(request);

        Vues.afficherResultatImportation(request, response, message);
    }

    private String importationExcel(HttpServletRequest request) throws IOException, ServletException {
        // un StringBuilder permet de construire une chaine au fur et à mesure,
        // tout en gardant des performances convenables
        StringBuilder messageBuilder = new StringBuilder();

        Part filePart = request.getPart("file");
        InputStream filecontent = filePart.getInputStream();
        if (filecontent == null)
            return "Impossible de récupérer le contenu du fichier envoyé<br/>";

        HSSFWorkbook wordbook = new HSSFWorkbook(filecontent);
        HSSFSheet sheet = wordbook.getSheetAt(0);
        if (sheet == null)
            return "Impossible de récupérer la première feuille du Workbook<br/>";

        // cet objet nous permet de parcourir le fichier uploadé ligne par ligne
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // cette ligne est peut être une ligne comme "Catégories", "Fabricants", ou "Produits"
            // à ce moment, on déclenche la lecture de la section correspondante
            Cell maybeSectionCell = row.getCell(0);
            if (maybeSectionCell == null)
                continue;

            switch (maybeSectionCell.getStringCellValue()) {
                case "Catégories":
                    lireCategories(rowIterator, messageBuilder);
                    break;

                case "Fabricants":
                    lireFabricants(rowIterator, messageBuilder);
                    break;

                case "Produits":
                    lireProduits(rowIterator, messageBuilder);
                    break;
            }
        }

        return messageBuilder.toString();
    }

    /**
     * Consomme les lignes pour créer des Categorie
     * <p>
     * Commence quand on recontre la ligne d'entête, jusqu'à ce qu'une ligne vide soit rencontrée
     *
     * @param rowIterator
     */
    private void lireCategories(Iterator<Row> rowIterator, StringBuilder messageBuilder) {
        boolean headerSeen = false;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (isEmptyCell(row.getCell(1)))
                return;

            if (headerSeen) {
                Categorie categorie = new Categorie();
                categorie.setId(getIdFromRow(row));
                categorie.setNom(row.getCell(1).getStringCellValue());

                if (categorie.getId() != null) {
                    messageBuilder.append("Mise à jour de la catégorie " + categorie.getId() + "<br/>");
                    gestionCategories.update(categorie);
                } else {
                    messageBuilder.append("Création de la catégorie " + categorie.getNom() + "<br/>");
                    gestionCategories.add(categorie);
                }
            } else {
                headerSeen = doesLineMatch(row, "ID", "Nom");
                if (headerSeen)
                    messageBuilder.append("Lecture des catégories<br/>");
            }
        }
    }

    /**
     * Consomme les lignes pour créer des Fabricant
     * <p>
     * Commence quand on recontre la ligne d'entête, jusqu'à ce qu'une ligne vide soit rencontrée
     *
     * @param rowIterator
     */
    private void lireFabricants(Iterator<Row> rowIterator, StringBuilder messageBuilder) {
        boolean headerSeen = false;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (isEmptyCell(row.getCell(1)))
                return;

            if (headerSeen) {
                Fabricant fabricant = new Fabricant();
                fabricant.setId(getIdFromRow(row));
                fabricant.setNom(row.getCell(1).getStringCellValue());
                fabricant.setAdresse(row.getCell(2).getStringCellValue());

                if (fabricant.getId() != null) {
                    messageBuilder.append("Mise à jour du fabricant " + fabricant.getId() + "<br/>");
                    gestionFabricants.update(fabricant);
                } else {
                    messageBuilder.append("création du fabricant " + fabricant.getId() + "<br/>");
                    gestionFabricants.add(fabricant);
                }
            } else {
                headerSeen = doesLineMatch(row, "ID", "Nom", "Adresse");
                if (headerSeen)
                    messageBuilder.append("Lecture des fabricants<br/>");
            }
        }
    }

    /**
     * Consomme les lignes pour créer des Produit
     * <p>
     * Commence quand on recontre la ligne d'entête, jusqu'à ce qu'une ligne vide soit rencontrée
     *
     * @param rowIterator
     */
    private void lireProduits(Iterator<Row> rowIterator, StringBuilder messageBuilder) {
        boolean headerSeen = false;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (isEmptyCell(row.getCell(1)))
                return;

            if (headerSeen) {
                int categorieId = Integer.parseInt(row.getCell(1).getStringCellValue());
                Categorie categorie = gestionCategories.findById(categorieId);
                if (categorie == null) {
                    System.out.println("Catégorie vide !!");
                    continue;
                }

                int fabricantId = Integer.parseInt(row.getCell(3).getStringCellValue());
                Fabricant fabricant = gestionFabricants.findById(fabricantId);
                if (fabricant == null) {
                    System.out.println("Fabricant vide !!");
                    continue;
                }

                Produit produit = new Produit();
                produit.setId(getIdFromRow(row));
                produit.setNom(row.getCell(5).getStringCellValue());
                produit.setFabricant(fabricant);
                produit.setCategorie(categorie);

                if (produit.getId() != null) {
                    messageBuilder.append("Mise à jour du produit " + produit.getId() + "<br/>");
                    gestionProduits.update(produit);
                } else {
                    messageBuilder.append("Création du produit " + produit.getNom() + "<br/>");
                    gestionProduits.add(produit);
                }
            } else {
                headerSeen = doesLineMatch(row, "ID", "ID_Catégorie", "Catégorie", "ID_Fabricant", "Fabricant", "Nom");
                if (headerSeen)
                    messageBuilder.append("Lecture des produits<br/>");
            }
        }
    }

    /**
     * Indique si une ligne commence par des cellules avec le texte indiqué en paramètre
     *
     * @param row
     * @param cellTexts
     * @return
     */
    private boolean doesLineMatch(Row row, String... cellTexts) {
        for (int i = 0; i < cellTexts.length; i++) {
            Cell cell = row.getCell(i);
            if (cell == null)
                return false;

            if (!cellTexts[i].equals(cell.getStringCellValue()))
                return false;
        }

        return true;
    }

    private boolean isEmptyCell(Cell cell) {
        return cell == null
                || cell.getStringCellValue() == null
                || cell.getStringCellValue().trim().isEmpty();
    }

    /**
     * Trouve l'id de l'enregistrement décrit par la ligne excel courante.
     * L'id se trouve dans la première cellule de la ligne
     *
     * @param row
     * @return
     */
    private Integer getIdFromRow(Row row) {
        if (row == null)
            return null;

        return getCellValueAsInt(row.getCell(0));
    }

    /**
     * Retourne le contenu d'une cellule vu comme un Integer
     *
     * @param cell
     * @return
     */
    private Integer getCellValueAsInt(Cell cell) {
        if (cell == null)
            return null;

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();

            case STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue());
                } catch (Exception e) {
                    return null;
                }
        }

        return null;
    }
}