package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Produit;

import javax.ejb.Stateless;

@Stateless
public class GestionProduits extends GestionGenerique<Produit> {
    public GestionProduits() {
        super(Produit.class);
    }
}
