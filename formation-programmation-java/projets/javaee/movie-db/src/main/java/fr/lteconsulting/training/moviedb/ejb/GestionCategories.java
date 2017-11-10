package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Categorie;

import javax.ejb.Stateless;

@Stateless
public class GestionCategories extends GestionGenerique<Categorie> {
    public GestionCategories() {
        super(Categorie.class);
    }
}
