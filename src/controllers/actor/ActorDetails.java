package controllers.actor;

import dao.ActorDAO;
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

public class ActorDetails extends HttpServlet {
    private final ActorDAO actorDAO = new ActorDAO();
    private final FilmDAO filmDAO = new FilmDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int actorId = Integer.parseInt(req.getParameter("id"));
        Actor actor = actorDAO.getOne(actorId);
        List<Film> films = filmDAO.getAllFilmsOfActor(actorId);
        actor.setFilms(films);
        req.setAttribute("actor", actor);
        req.getRequestDispatcher("ActorDetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        actorDAO.delete(id);
        List<Actor> actors = actorDAO.getAll();
        req.setAttribute("list", actors);
        req.getRequestDispatcher("ActorsList.jsp").forward(req, resp);
    }
}
