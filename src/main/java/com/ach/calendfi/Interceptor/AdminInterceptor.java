package com.ach.calendfi.Interceptor;

import com.ach.calendfi.customexception.ResultBody;
import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminInterceptor implements HandlerInterceptor {

    /**
     * Called before the request is processed (before the Controller method is called)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "*");
            /* The asterisk indicates that all domains are acceptable */
            response.setHeader("Access-Control-Allow-Methods", "GET,POST");
            String accessToken = request.getHeader("accessToken");
            boolean b = false;
            if (StringUtils.hasText(accessToken)) {
                b = JWTUtil.verifyToken(accessToken);
            }
            if (b) {
                return b;
            }
            pleaseLogin(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;//If set to false, the interceptor will not continue to operate when requested
        //If set to true, the request will continue to perform subsequent operations
    }

    /**
     * Called after the request is processed, but before the view is rendered (after the Controller method is called)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * Called after the entire request is over, that is, executed after the DispatcherServlet renders the corresponding view (mainly used for resource cleaning)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    private void pleaseLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        ResultBody error = ResultBody.error("500", "Token Error");
        writer.write(JSON.toJSONString(error));
    }
}