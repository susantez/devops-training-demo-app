package com.definex.devopstraining.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestIntercepterImpl implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestIntercepterImpl.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress = request.getHeader("X-Forward-For");

        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        LOGGER.info ("requester: " + ipAddress);
        return true;
    }
}
