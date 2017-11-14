package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Produit;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GestionProduits extends GestionGenerique<Produit> {
    public GestionProduits() {
        super(Produit.class);
    }

    public List<Produit> findByName(String search) {
        TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.nom like :search", Produit.class);
        query.setParameter("search", "%" + search + "%");
        return query.getResultList();
    }
}
