package filters.profile;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IsUserLogged implements Filter {
    @Inject
    private UsersService usersService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = request.getSession(false).getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }

        request.setAttribute("loggedUser", user);
        filterChain.doFilter(request, resp);
    }
}
