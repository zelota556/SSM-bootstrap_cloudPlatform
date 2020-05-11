package com.zelot.Interceptor;


import com.zelot.ModelDo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        logger.info("用户登录拦截");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userSession");
        if (user != null) {
            return true;
        } else {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }
}
