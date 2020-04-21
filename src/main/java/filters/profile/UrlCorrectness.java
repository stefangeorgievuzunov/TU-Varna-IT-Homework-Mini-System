package filters.profile;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UrlCorrectness implements Filter {
    @Inject
    private UsersService usersService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String parameter = request.getParameter("id");
        Map<String, String[]> urlParams = request.getParameterMap();

        if (urlParams.isEmpty()) {
            UserModel loggedUser = (UserModel) request.getAttribute("loggedUser");
            resp.sendRedirect("/profile?id=" + loggedUser.getId());
        } else if (!urlParams.isEmpty() &&  !urlParams.containsKey("id")) {
            //TODO page not found
            resp.sendRedirect("/users/all");
        } else {
            try {
                Integer id = Integer.parseInt(urlParams.get("id"));
                UserModel showUserProfile = usersService.getUserById(id);

                if (showUserProfile == null) {
                    //TODO show page 404
                    resp.sendRedirect("/users/all");
                } else {
                    request.setAttribute("user", showUserProfile);
                    filterChain.doFilter(request, resp);
                }
            } catch (NumberFormatException e) {
                //TODO show page 404
                resp.sendRedirect("/users/all");
            }
        }
    }
}
