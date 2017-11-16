package fr.lteconsulting.training.moviedb.ejb;

import fr.lteconsulting.training.moviedb.model.Utilisateur;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Stateless
public class GestionUtilisateur extends GestionGenerique<Utilisateur> {
    public GestionUtilisateur() throws NoSuchFieldException {
        super(Utilisateur.class);
    }

    public Utilisateur login(String login, String password) {
        try {
            TypedQuery<Utilisateur> query = em.createQuery("select u from Utilisateur u where u.login=:login and u.password=:password", Utilisateur.class)
                    .setParameter("login", login)
                    .setParameter("password", password);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Utilisateur findByLogin(String login) {
        try {
            return em.createQuery("select u from Utilisateur u where u.login=:login", Utilisateur.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
