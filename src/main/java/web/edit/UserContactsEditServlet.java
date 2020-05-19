package web.edit;

import com.google.gson.Gson;
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

@WebServlet("/fetch/contacts")
public class UserContactsEditServlet extends HttpServlet {
    @Inject
    private Gson gson;
    @Inject private UsersService usersService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = req.getReader().readLine()) != null) {
            sb.append(s);
        }

        UserModel user = gson.fromJson(sb.toString(), UserModel.class);
        UserModel result= usersService.contactsEdit(user);


        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(gson.toJson(result));
        out.flush();
    }
}
