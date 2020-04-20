package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/profile","/profile/edit"})
public class ProfileFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;

        Object user=request.getSession().getAttribute("user");

        if(user==null){
            resp.sendRedirect("/login");
        }else{
            request.setAttribute("user",user);
            filterChain.doFilter(request,resp);
        }
    }
}
