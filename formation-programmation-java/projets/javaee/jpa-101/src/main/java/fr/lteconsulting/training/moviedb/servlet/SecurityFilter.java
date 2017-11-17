package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.outil.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;

            if (request.getRequestURI().endsWith(".css")
                    || request.getRequestURI().endsWith("/login")
                    || request.getRequestURI().endsWith("/inscription")
                    || Session.estConnecte(request))
                chain.doFilter(req, resp);
            else
                response.sendRedirect("login");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void destroy() {
    }
}
