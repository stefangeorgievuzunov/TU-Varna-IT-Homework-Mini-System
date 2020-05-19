package filters.profile;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IsUserLoggedValidator implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = request.getSession(false).getAttribute("user");

        if(user!=null){
            request.setAttribute("loggedUser", user);
            filterChain.doFilter(request, resp);
            return;
        }
        resp.sendRedirect("/login");
    }
}
