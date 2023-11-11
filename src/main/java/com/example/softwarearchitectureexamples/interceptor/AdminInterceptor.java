package com.example.softwarearchitectureexamples.interceptor;

import com.example.softwarearchitectureexamples.dox.User;
import com.example.softwarearchitectureexamples.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int role = (int) request.getAttribute("role");
        if (role != User.ADMIN) {
            throw new XException("无权限");
        }
        return true;
    }
}
