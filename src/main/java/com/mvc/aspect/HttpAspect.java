package com.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2017-01-15 12:31
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.mvc.controller.GirlController.*(..))")
    public void log() {
    }

    @Around("log()")
    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("6、执行-----HttpAspect----doAround--before---");
         pjp.proceed();
        logger.info("13、执行-----HttpAspect----doAround--after---");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("7、执行-----HttpAspect----doBefore-----");

        // ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // HttpServletRequest request = attributes.getRequest();
        //
        // //url
        // logger.info("url={}", request.getRequestURL());
        //
        // //method
        // logger.info("method={}", request.getMethod());
        //
        // //ip
        // logger.info("ip={}", request.getRemoteAddr());
        //
        // //类方法
        // logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //
        // //参数
        // logger.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
        logger.info("14、执行-----HttpAspect----doAfter-----");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        // logger.info("response={}", object.toString());
        logger.info("15、执行-----HttpAspect----doAfterReturning-----");
    }

}
