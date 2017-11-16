package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.outil.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {
        "/produits",
        "/editionProduit",
        "/suppressionProduit",
        "/categories",
        "/editionCategorie",
        "/suppressionCategorie",
        "/fabricants",
        "/editionFabricant",
        "/suppressionFabricant",
        "/export.xls",
        "/importation"
})
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {
            if (!Session.estConnecte((HttpServletRequest) req)) {
                ((HttpServletResponse) resp).sendRedirect("login");
                return;
            }
        }

        chain.doFilter(req, resp);
    }

    public void destroy() {
    }
}
