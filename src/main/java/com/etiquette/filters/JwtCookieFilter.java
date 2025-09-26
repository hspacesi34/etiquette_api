package com.etiquette.filters;

import java.io.IOException;

import com.etiquette.services.JwtService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtCookieFilter implements Filter {
    private final JwtService jwtService;

    public JwtCookieFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Optional: init logic
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getServletPath();

        // Exclude certain routes from filtering
        if (path.contains("/user/login") || path.contains("/user/signin") || path.contains("/user/istokenvalid") || path.contains("/board/add")) {
            chain.doFilter(request, response);
            return;
        }
        
        // Extract token from cookie
        String token = null;
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if ("jwt-token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null || !jwtService.isTokenValid(token) || jwtService.isTokenExpired(token)) {
            // Token missing or invalid: reject request
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Unauthorized: Invalid or missing token");
            return;
        }
        
        if (jwtService.getRole(token).toString().contains("user")) {
            if (
                path.endsWith("/one")
                || path.endsWith("/add")
                || path.endsWith("/update")
                || path.contains("/user/login")
                || path.contains("/user/signin")
                ) {
                    if (path.contains("/user/add") || path.contains("/user/update")) {
                        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        res.getWriter().write("Unauthorized: Invalid role");
                        return;
                    } else {
                        chain.doFilter(request, response);
                    }
                } else {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Unauthorized: Invalid role");
                return;
            }
        }
    }

    @Override
    public void destroy() {
        // Optional: cleanup logic
    }
}
