package org.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.example.pojo.Result;
import org.example.utils.JwtUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");

        // 获取请求URL
        String url = request.getRequestURI();
        log.info("请求的URL：{}",url);

        // 获取请求头中的令牌
        String jwt = request.getHeader("token");

        // 判断令牌是否存在，如果不存在，返回错误信息
        if(jwt == null){
            log.info("请求的token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象--JSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 解析token，如果解析失败，返回错误信息
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            log.info("解析令牌失败，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象--JSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
