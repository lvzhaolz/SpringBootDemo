package com.example.demo.config;

import com.example.demo.interceptor.CustomInterceptor;
import com.example.demo.model.CustomBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Bean(name = "customBean555")
    public CustomBean customBean555() {
        return new CustomBean("test123123");
    }

    @Bean(name = "customBean55")
    public CustomBean customBean55() {
        return new CustomBean("test55");
    }

    @Bean
    CustomInterceptor getCustomInterceptor() {
        return new CustomInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCustomInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 手动配置过滤器，还有一种是注解形式@WebFilter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 过滤器
     */
    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            System.out.println("this is MyFilter,url :" + httpRequest.getRequestURI());
            filterChain.doFilter(httpRequest, response);
//            return;
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setStatus(401);

        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
    }
}
