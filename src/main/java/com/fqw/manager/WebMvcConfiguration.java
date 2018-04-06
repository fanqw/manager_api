package com.fqw.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fqw.manager.interceptor.RequestInterceptor;

public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
   RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // 映射为 user 的控制器下的所有映射
   registry.addInterceptor(requestInterceptor).addPathPatterns("/").excludePathPatterns("/index", "/");
        super.addInterceptors(registry);
    }

}
