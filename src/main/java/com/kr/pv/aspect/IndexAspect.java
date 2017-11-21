package com.kr.pv.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class IndexAspect {

	private static final Logger logger = LoggerFactory.getLogger(IndexAspect.class);
		@Before("execution(public * com.kr.pv.controller..getPv(..))")
		public void loginCheck() throws Throwable {
			HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			String userName = req.getParameter("userName");
			String password = req.getParameter("password");		
		}

	
}
