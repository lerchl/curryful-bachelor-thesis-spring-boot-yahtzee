package io.github.curryful.yahtzee;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class YahtzeeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().equals("/yahtzee")) {
            String sessionToken = request.getHeader("Authorization");
            if (sessionToken != null && sessionToken.equals("bobSessionToken")) {
                response.setHeader("Joke", "Why don't skeletons fight each other? They don't have the guts.");
            }
        }

        return true;
    }
}
