package com.goldminds.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author bessam on 25/08/2021
 */

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger;

	public LoggingAspect(Logger logger) {
		this.logger = logger;
		logger.info("#################STARTING THE LOGGIN ASPECT #########################");
	}

	@Before("execution(public * com.goldminds.core.*.*.*(..)) || execution(public * com.goldminds.common.*.*Abstract*.*(..))")
	public void logMethodInfo(JoinPoint joinPoint) {

		try {
			logger.debug( joinPoint.getSignature().getDeclaringTypeName() +" : "+joinPoint.getSignature().getName()+" : " + Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}