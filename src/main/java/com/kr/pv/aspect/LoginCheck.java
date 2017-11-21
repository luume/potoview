package com.kr.pv.aspect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
public class LoginCheck {
	private static final Logger logger = LoggerFactory.getLogger(LoginCheck.class);
	@Around("execution(public * com.kr.pv.controller..loginOk(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		System.out.println("로그인 체크 AOP");
		try {
			if(userName.equals("admin") && password.equals("0000")) {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("showImg", "1");
				System.out.println("로그인성공 , " + httpSession.getAttribute("showImg"));
				Object obj = joinPoint.proceed();
				
				return obj;
			}else {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("showImg", "0");
				System.out.println("로그인실패 , " + httpSession.getAttribute("showImg"));
				return "redirect:/index";
			}
			
		} finally {
			// 공통기능
			System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. " + System.currentTimeMillis());
		}
	}
}
