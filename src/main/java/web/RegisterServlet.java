package web;

import services.UsersService;
import services.impl.UsersServiceImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Inject
    private  UsersService usersService;

    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String rePassword=req.getParameter("rePassword");

        try{
            usersService.register(name,email,password,rePassword);
            resp.sendRedirect("/login");
        }catch(Exception excep){
            excep.printStackTrace();
            doGet(req,resp);
        }
    }
}
