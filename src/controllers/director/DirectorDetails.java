package controllers.director;

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

public class DirectorDetails extends HttpServlet {
    private final FilmDAO filmDAO = new FilmDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int directorId = Integer.parseInt(req.getParameter("id"));
        Director director = directorDAO.getOne(directorId);
        List<Film> films = filmDAO.getFilmsOfDirector(directorId);
        director.setFilms(films);
        req.setAttribute("director", director);
        req.getRequestDispatcher("DirectorDetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        directorDAO.delete(id);
        List<Director> directors = directorDAO.getAll();
        req.setAttribute("list", directors);
        req.getRequestDispatcher("DirectorsList.jsp").forward(req, resp);
    }
}
