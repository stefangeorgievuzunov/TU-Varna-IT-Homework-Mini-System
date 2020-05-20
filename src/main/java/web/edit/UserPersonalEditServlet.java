package web.edit;

import com.google.gson.Gson;
import services.ResponseWriter;
import services.UsersService;
import services.models.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fetch/personal")
public class UserPersonalEditServlet extends HttpServlet {
    @Inject
    private UsersService usersService;
    @Inject
    private ResponseWriter responseWriter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        responseWriter.write(req, resp, usersService::personalEdit);
    }
}
