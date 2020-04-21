package filters;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/profile/edit")
public class ProfileEditFilter implements Filter {
    @Inject
    private UsersService usersService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = request.getSession(false).getAttribute("user");

        Integer id = Integer.parseInt(request.getParameter("id"));
        UserModel showUserProfile = usersService.getUserById(id);
//
//        if (user == null) {
//            resp.sendRedirect("/login");
//        } else if () {
//
//        } else {
//            request.setAttribute("user",user);
//            request.setAttribute("viewProfile", showUserProfile);
//            filterChain.doFilter(request, resp);
//        }
    }
}
