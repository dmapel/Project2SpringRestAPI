package com.revature.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.Page;

@Aspect
@Configuration
public class Logging {

	private Logger logger = Logger.getLogger(this.getClass());

	@AfterReturning("execution(* com.revature.service.*.*(..))")
	public void logService(JoinPoint joinPoint) throws Throwable {
		logger.info("Used service " + joinPoint);
	}

	@Before("execution(* com.revature.web.LoginCtrl.*(..))")
	public void logLogin(JoinPoint joinPoint) throws Throwable {
		logger.info("Login endpoint hit " + joinPoint);
	}

	@Before("execution(* com.revature.web.PageCtrl.*(..))")
	public void logPage(JoinPoint joinPoint) throws Throwable {
		logger.info("Page endpoint hit " + joinPoint);
	}

	@Before("execution(* com.revature.web.TagCtrl.*(..))")
	public void logTag(JoinPoint joinPoint) throws Throwable {
		logger.info("Tag endpoint hit " + joinPoint);
	}

	@Before("execution(* com.revature.web.CommentCtrl.*(..))")
	public void logComment(JoinPoint joinPoint) throws Throwable {
		logger.info("Comment endpoint hit " + joinPoint);
	}

	@AfterReturning(pointcut = "execution(* com.revature.service.PageService.createPage(..))", returning = "returnValue")
	public void logPageCreated(JoinPoint joinPoint, Object returnValue) throws Throwable {
		logger.info("New page created:" + returnValue);
	}

}
