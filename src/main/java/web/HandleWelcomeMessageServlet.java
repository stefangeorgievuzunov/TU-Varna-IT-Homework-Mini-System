package web;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/profile/close")
public class HandleWelcomeMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTime now = DateTime.now();
        long secondsUntilTomorrow = new Duration( now , now.plusDays( 1 ).withTimeAtStartOfDay() ).getStandardSeconds();

        Cookie welcomeMessage=new Cookie("welcomeMsg","seen");
        welcomeMessage.setMaxAge((int)secondsUntilTomorrow);

        resp.addCookie(welcomeMessage);
        resp.sendRedirect("/profile");
        return;
    }
}
