package fr.lteconsulting.training.moviedb.outil;

import fr.lteconsulting.training.moviedb.model.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
    private final static String USER_KEY = "utilisateurConnecte";

    public static void setUtilisateurConnecte(HttpSession session, Utilisateur utilisateur) {
        session.setAttribute(USER_KEY, utilisateur);
    }

    public static Utilisateur getUtilisateurConnecte(HttpSession session) {
        return (Utilisateur) session.getAttribute(USER_KEY);
    }

    public static boolean estConnecte(HttpServletRequest request) {
        return getUtilisateurConnecte(request.getSession()) != null;
    }
}
