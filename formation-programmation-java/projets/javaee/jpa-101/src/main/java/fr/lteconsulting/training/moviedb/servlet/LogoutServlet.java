package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.outil.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session.setUtilisateurConnecte(req.getSession(), null);
        resp.sendRedirect("login");
    }
}
