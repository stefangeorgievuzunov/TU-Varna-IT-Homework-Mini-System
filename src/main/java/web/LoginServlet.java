package web;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = (UserModel) req.getSession(false).getAttribute("user");
        if (user != null) {
            resp.sendRedirect("/profile");
            return;
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").toString();
        String password = req.getParameter("password").toString();

        UserModel user = usersService.login(email, password);

        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/profile");
        } else {
            doGet(req, resp);
        }
    }
}
