package com.noaa.tcdis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.noaa.tcdis")
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
    /**
     * 인터셉터 추가
     
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new CorsInterceptor());
    }
    */
}
