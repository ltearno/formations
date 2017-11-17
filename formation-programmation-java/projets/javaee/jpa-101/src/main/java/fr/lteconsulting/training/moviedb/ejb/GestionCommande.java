package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Commande;

import javax.ejb.Stateless;

@Stateless
public class GestionCommande extends GestionGenerique<Commande> {
    public GestionCommande() throws NoSuchFieldException {
        super(Commande.class);
    }
}
