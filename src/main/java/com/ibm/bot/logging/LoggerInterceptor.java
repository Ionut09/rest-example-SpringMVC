package com.ibm.bot.logging;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
		private Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
		public boolean preHandle(HttpServletRequest request, 
				HttpServletResponse response, Object handler)
		    throws Exception {
			log.debug(request.toString()); 
			return true;
		}

		public void postHandle(
				HttpServletRequest request, HttpServletResponse response, 
				Object handler, ModelAndView modelAndView)
				throws Exception {
		
	}
}
