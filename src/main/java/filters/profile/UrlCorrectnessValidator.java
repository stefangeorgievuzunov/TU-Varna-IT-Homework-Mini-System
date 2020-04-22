package filters.profile;

import models.UserModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UrlCorrectnessValidator implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Map<String, String[]> urlParams = request.getParameterMap();

        if (urlParams.isEmpty()) {

            UserModel loggedUser = (UserModel)request.getAttribute("loggedUser");
            if (loggedUser != null) {
                resp.sendRedirect(request.getRequestURI() + "?id=" + loggedUser.getId());
            }

        } else if (!urlParams.containsKey("id")) {
            //TODO page not found
            resp.sendRedirect("/users/all");
        } else {
            filterChain.doFilter(request, resp);
        }
    }
}
