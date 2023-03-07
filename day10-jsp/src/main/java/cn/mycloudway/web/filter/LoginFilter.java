package cn.mycloudway.web.filter;

import cn.mycloudway.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String[] urlWhiteList = {
                "/css", "/imgs", "/login", "/register", "/checkCode"
        };
        String currentUrl = httpServletRequest.getRequestURL().toString();

        for (String url : urlWhiteList) {
            if (currentUrl.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user == null) {
            httpServletRequest.setAttribute("login_msg", "您尚未登录");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
