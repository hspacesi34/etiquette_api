package com.etiquette.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etiquette.services.JwtService;

@Configuration
public class FilterConfig {

    private final JwtService jwtService;

    public FilterConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public FilterRegistrationBean<JwtCookieFilter> jwtCookieFilter() {
        FilterRegistrationBean<JwtCookieFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtCookieFilter(jwtService));
        registrationBean.addUrlPatterns("/*");  // Filter all routes
        registrationBean.setOrder(1);           // Filter order, if you have multiple filters

        return registrationBean;
    }
}
