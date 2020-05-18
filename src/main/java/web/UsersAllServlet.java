package web;

import services.models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users/all")
public class UsersAllServlet extends HttpServlet {
    @Inject
    private UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> usersAll=usersService.getAllUsers();

        if(!usersAll.isEmpty()) {
            req.setAttribute("usersAll", usersAll);
            req.getRequestDispatcher("/users_all.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/users_all_empty.jsp").forward(req, resp);
        }
    }
}
