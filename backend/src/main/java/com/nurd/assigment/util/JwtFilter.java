package com.nurd.assigment.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("jwtFilter")
public class JwtFilter extends OncePerRequestFilter {


    private String jwt = "";
    private String requestUri = "";

    @Autowired
    JwtTokenUtil jwtUtil;


    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//         if(request.getMethod().equals(RequestMethod.POST.toString()) || request.getMethod().equals(RequestMethod.GET.toString())){
//             AtomicBoolean isAccepted  = new AtomicBoolean();
//             requestUri = request.getRequestURI();
//             if (!isExcluded()) {
//                 jwt = request.getHeader("Authorization");
//                 if (jwt != null && !jwt.trim().isEmpty()) {
//                     if (jwtUtil.validateJwtToken(jwt)) {
//                         String jwtUsername = jwtUtil.getUserFromJwt(jwt);
//                         if (!jwtUsername.equals(adminUserName)) {
//                             User user = new User();
//                             user.setEmail(jwtUsername);
//                             user = userService.get(user);
//                             for (Role r : user.getRoles()) {
//                                 Role role = roleService.get(r);
//                                 role.getPermissions().stream().forEach(permission -> {
//                                     if (permission.isRead()) {
//                                         permission.getReadMethods().forEach(s -> {
//                                             if (s.equals(requestUri)) {
//                                                 isAccepted.set(true);
//                                                 return;
//                                             }
//                                         });
//                                     }
//                                     if (permission.isWrite()) {
//                                         permission.getWriteMethods().forEach(s -> {
//                                             if (s.equals(requestUri)) {
//                                                 isAccepted.set(true);
//                                                 return;
//                                             }
//                                         });
//                                     }
//                                 });
//                             }
//                             if (!isAccepted.get()) {
//                                 throw new ServletException("You are not authorized for this transaction! ->" + requestUri);
//                             }
//                         }
//
//                     } else {
//                         throw new ServletException("Authentication Failed  ->" + requestUri);
//                     }
//
//                 } else {
//                     throw new ServletException("Authorization Failed ->" + requestUri);
//                 }
//
//             }
//         }


        filterChain.doFilter(request, response);

    }

    private boolean isExcluded() {
        if (requestUri.contains("/fontawesome") || requestUri.contains("api/unsecured") || requestUri.contains("/static") ||
                requestUri.contains("/img") || requestUri.equals("/favicon.ico") || requestUri.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
