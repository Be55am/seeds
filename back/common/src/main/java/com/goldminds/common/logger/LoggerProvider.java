package com.goldminds.common.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author bessam on 25/08/2021
 */

/**
 * Configuration that creates a logging bean
 */
@Configuration
public class LoggerProvider {


	/**
	 * get a logging bean SL4J logger instance
	 * @param injectionPoint the injection point will be injected
	 * @return logger
	 */
	@Bean
	@Scope("prototype")
	public Logger createLogger(final InjectionPoint injectionPoint) {
		Class<?> clazz = injectionPoint.getMember().getDeclaringClass();
		return LoggerFactory.getLogger(clazz);
	}
}
