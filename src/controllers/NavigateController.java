package controllers;

import beans.FilmBean;
import dao.ActorDAO;
import dao.DAO;
import dao.DirectorDAO;
import dao.FilmDAO;
import model.Actor;
import model.Director;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NavigateController extends HttpServlet {
    private final FilmDAO filmDAO = new FilmDAO();
    private final ActorDAO actorDAO = new ActorDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if ("films".equals(entity)) {
            List<Film> films = filmDAO.getAll();
            req.setAttribute("list", films);
            req.getRequestDispatcher("FilmsList.jsp").forward(req, resp);
        } else if("directors".equals(entity)){
            List<Director> directors = directorDAO.getAll();
            req.setAttribute("list", directors);
            req.getRequestDispatcher("DirectorsList.jsp").forward(req, resp);
        }
        else{
            List<Actor> actors = actorDAO.getAll();
            req.setAttribute("list", actors);
            req.getRequestDispatcher("ActorsList.jsp").forward(req, resp);
        }
    }
}
