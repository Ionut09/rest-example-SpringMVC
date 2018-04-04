package com.ibm.bot.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import com.ibm.bot.logging.LoggerInterceptor;

@Configuration
@ComponentScan(basePackages = "com.ibm.bot")
public abstract class ApplicationConfiguration  extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new LoggerInterceptor());
	}

}
