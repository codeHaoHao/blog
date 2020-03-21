package com.lijiahao.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.lijiahao.blog.interceptor.BaseInterceptor;

/**
 * Spring MVC 配置文件
 * @author Frank Li
 *
 */

@Configuration
public class SpringMvcConfig extends WebMvcConfigurationSupport{
	
	@Autowired
	private BaseInterceptor baseInterceptor;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(baseInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/captcha.html",
				"/admin/dologin.html", "/admin/login.html","/js/**", "/css/**","/images/**","/fonts/**","/static/**");
	}
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
		registry.addResourceHandler("/admin/copyright.html").addResourceLocations("classpath:/templates/admin/copyright.html");
		registry.addResourceHandler("/favicon.ico").addResourceLocations ("classpath:/static/css/favicon.ico");
	}
}
