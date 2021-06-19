package com.gdou.gms.config;

import com.gdou.gms.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

// 定制springmvc的功能
@Configuration
public class WebConfig implements WebMvcConfigurer
{

    /**
     * 将拦截器放在这里配置
     * @param registry 拦截器的注册中心
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        List<String> excludePaths = new ArrayList<>();
        excludePaths.add("/");
        excludePaths.add("/login");
        excludePaths.add("/css/**");
        excludePaths.add("/js/**");
        excludePaths.add("/getMsg");

        // addInterceptor添加拦截器，addPathPatterns配置拦截的路径，拦截所有（包括静态资源），excludePathPatterns配置放行的路径、静态资源
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);

    }
}
