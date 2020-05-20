package web.edit;

import services.ResponseWriter;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fetch/contacts")
public class UserContactsEditServlet extends HttpServlet {
    @Inject private UsersService usersService;
    @Inject private ResponseWriter responseWriter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        responseWriter.write(req,resp,usersService::contactsEdit);
    }
}
