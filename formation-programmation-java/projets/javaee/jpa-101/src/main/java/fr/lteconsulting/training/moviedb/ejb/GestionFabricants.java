package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Fabricant;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class GestionFabricants extends GestionGenerique<Fabricant> {
    public GestionFabricants() {
        super(Fabricant.class);
    }

    public Long getNbProduitParFabricantId(Integer id) {
        TypedQuery<Long> query = em.createQuery("select count(p) from Produit p where p.fabricant.id=:id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
