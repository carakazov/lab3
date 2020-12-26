package controllers.film;

import dao.DirectorDAO;
import dao.FilmDAO;
import model.Director;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FilmDetailsController extends HttpServlet {
    private final FilmDAO filmDAO = new FilmDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int filmId = Integer.parseInt(req.getParameter("id"));
        Film film = filmDAO.getOne(filmId);
        film.setDirector(directorDAO.getOne(film.getDirectorId()));
        req.setAttribute("film", film);
        req.getRequestDispatcher("FilmDetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = (int)req.getAttribute("id");
        filmDAO.delete(id);
        List<Film> films = filmDAO.getAll();
        for (Film f : films) {
            Director director = directorDAO.getOne(f.getDirectorId());
            f.setDirector(director);
        }
        req.setAttribute("list", films);
        req.getRequestDispatcher("FilmsList.jsp").forward(req, resp);
    }
}
