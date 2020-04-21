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

@WebServlet(urlPatterns = {"/profile", "/profile/edit"})
public class UserServlet extends HttpServlet {
    @Inject
    private UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/profile/edit")) {
            req.getRequestDispatcher("/profile_edit.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String job = req.getParameter("job");
        String desc = req.getParameter("desc");
        String city = req.getParameter("city");
        String phoneNumber = req.getParameter("phoneNumber");
        String street = req.getParameter("street");

        UserModel user = usersService.edit(req, name, job, desc, city, phoneNumber, street);

        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/profile");
        } else {
            doGet(req, resp);
        }
    }
}
