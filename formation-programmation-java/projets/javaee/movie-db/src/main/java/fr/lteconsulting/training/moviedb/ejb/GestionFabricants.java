package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Fabricant;

import javax.ejb.Stateless;

@Stateless
public class GestionFabricants extends GestionGenerique<Fabricant> {
    public GestionFabricants() {
        super(Fabricant.class);
    }
}
