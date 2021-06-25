package com.gdou.gms.interceptor;

import com.gdou.gms.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 做登录检查，判断是否已经进行登录，没登录直接跳转到登录页面

/**
 * 步骤：
 * 1.配置拦截器要拦截的请求
 * 2.把这些配置放在容器中
 */
public class LoginInterceptor implements HandlerInterceptor
{

    /**
     * 在目标方法执行之前，在这里做登录检查
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod))
        {
            return true;
        }

        String token = request.getHeader("token");

        // 验证token有效性
        if (JwtUtil.checkToken(token))
        {
            return true;
        }
        else
        {
            response.setHeader("401", "TokenDisable");
            return false;
        }

    }

    /**
     * 在目标方法执行后，但还没进行页面跳转
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    /**
     * 在页面渲染之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
