package filters.profile.edit;

import models.UserModel;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessValidator implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        UserModel editUserProfile=(UserModel)request.getAttribute("user");
        UserModel loggedUser=(UserModel)request.getAttribute("loggedUser");

        if(!editUserProfile.getId().equals(loggedUser.getId())){
            resp.sendRedirect("/profile/edit?id="+loggedUser.getId());
        }else{
            filterChain.doFilter(request,resp);
        }
    }
}
