package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Categorie;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class GestionCategories extends GestionGenerique<Categorie> {
    public GestionCategories() throws NoSuchFieldException {
        super(Categorie.class);
    }

    public long getNbProduitParCategorieId(Integer id) {
        TypedQuery<Long> query = em.createQuery("select count(p) from Produit p where p.categorie.id=:id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
