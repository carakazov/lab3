package controllers.director;

import dao.DirectorDAO;
import model.Director;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddDirector extends HttpServlet {
    private final DirectorDAO directorDAO = new DirectorDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            Director director = new Director(name, surname);
            directorDAO.add(director);
            List<Director> directors = directorDAO.getAll();
            req.setAttribute("list", directors);
            req.getRequestDispatcher("DirectorsList.jsp").forward(req, resp);
        }catch (InternalError e){
            throw e;
        }
    }
}
