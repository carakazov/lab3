package controllers.actor;

import dao.ActorDAO;
import model.Actor;
import model.Director;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddActor extends HttpServlet {
    private final ActorDAO actorDAO = new ActorDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            Actor actor = new Actor(name, surname);
            actorDAO.add(actor);
            List<Actor> actors = actorDAO.getAll();
            req.setAttribute("list", actors);
            req.getRequestDispatcher("ActorsList.jsp").forward(req, resp);
        }catch (InternalError e){
            throw e;
        }
    }
}
