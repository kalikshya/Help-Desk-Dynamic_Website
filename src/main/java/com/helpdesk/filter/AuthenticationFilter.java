package com.helpdesk.filter;

import java.io.IOException;

import com.helpdesk.util.SessionUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@WebFilter(urlPatterns = {"/admindashboard/*", "/userdashboard/*"}) // protect dashboard URLs
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // optional: initialization logic
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Check if user is logged in
        Object user = (session != null) ? session.getAttribute("user") : null;

        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login"); // redirect if not logged in
            return;
        }

        // If user is logged in, allow the request to continue
        chain.doFilter(request, response);
    }
    

    @Override
    public void destroy() {
        // optional: clean-up logic
    }
}
