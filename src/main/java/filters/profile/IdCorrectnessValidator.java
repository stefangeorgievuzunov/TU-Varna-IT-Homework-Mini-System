package filters.profile;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdCorrectnessValidator implements Filter {
    @Inject
    private UsersService usersService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String paramId = request.getParameter("id");

        try {
            Integer id = Integer.parseInt(paramId);
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
