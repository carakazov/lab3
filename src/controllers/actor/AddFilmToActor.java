package controllers.actor;

import dao.ActorDAO;
import dao.FilmActorDAO;
import dao.FilmDAO;
import model.Actor;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddFilmToActor extends HttpServlet {
    private final FilmActorDAO dao = new FilmActorDAO();
    private final ActorDAO actorDAO = new ActorDAO();
    private final FilmDAO filmDAO = new FilmDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int actorId = Integer.parseInt(req.getParameter("actorId"));
        int filmId = Integer.parseInt(req.getParameter("filmId"));
        dao.add(filmId, actorId);
        Actor actor = actorDAO.getOne(actorId);
        List<Film> films = filmDAO.getAllFilmsOfActor(actorId);
        actor.setFilms(films);
        req.setAttribute("actor", actor);
        req.getRequestDispatcher("ActorDetails.jsp").forward(req, resp);
    }
}
