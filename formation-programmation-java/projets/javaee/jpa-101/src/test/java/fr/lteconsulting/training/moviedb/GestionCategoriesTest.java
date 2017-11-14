package fr.lteconsulting.training.moviedb;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.model.Categorie;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GestionCategoriesTest {
    @Test
    public void testGestionCategorie() {
        GestionCategories gestionCategories = new GestionCategories();

        gestionCategories.add(new Categorie());

        assertTrue(true);
    }
}
