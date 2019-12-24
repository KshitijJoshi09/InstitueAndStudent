package com.spiders.app.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
//@EnableAspectJAutoProxy
public class LoggingAspect {

	Logger log = Logger.getLogger(LoggingAspect.class);

	// @After("within(com.spiders.app.controller..*) ")
	// @Before("within(com.spiders.app.controller..*) ")

	@Around("within(com.spiders.app.controller..*) ")
	public Object Advice(ProceedingJoinPoint point) throws Throwable {

		Signature signature = point.getSignature();
		//log.trace(signature.toString());
		Object obj = point.proceed();
		
		/*
		 * System.out.println("naem " +signature.getName());;
		 * System.out.println("modifier "+Modifier.toString(signature.getModifiers()));
		 * System.out.println(obj);
		 * System.out.println(Arrays.toString(point.getArgs()));
		 */
		
		log.info(signature+" args ->"+Arrays.toString(point.getArgs()) + " result->"+obj );
		return obj;
	}

}
