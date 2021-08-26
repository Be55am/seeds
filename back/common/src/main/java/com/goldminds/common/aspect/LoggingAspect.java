package com.goldminds.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author bessam on 25/08/2021
 */

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger;

	public LoggingAspect(Logger logger) {
		this.logger = logger;
		System.out.println("################################ logger ################################");
		logger.info("#################STARTING THE LOGGIN ASPECT #########################");
	}

//	@Around("within(com.goldminds.common.controller.AbstractController+)")
	public Object logMethodInfo(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			logger.info("####### "+joinPoint.getSignature().getName());
			return joinPoint.proceed();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getCause();
		}
	}
}
