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

public class AddFilmServlet extends HttpServlet {
    private final FilmDAO filmDAO = new FilmDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String title = req.getParameter("title");
            int rating = Integer.parseInt(req.getParameter("rating"));
            int directorId = Integer.parseInt(req.getParameter("directorId"));
            Film film = new Film(title, directorId, rating);
            filmDAO.add(film);
            List<Film> films = filmDAO.getAll();
            for (Film f : films) {
                Director director = directorDAO.getOne(f.getDirectorId());
                f.setDirector(director);
            }
            req.setAttribute("list", films);
            req.getRequestDispatcher("FilmsList.jsp").forward(req, resp);
        }catch (InternalError e){
            throw e;
        }
    }
}
