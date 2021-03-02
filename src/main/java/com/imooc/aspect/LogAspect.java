package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 操作日志记录处理
 *
 * @author ruoyi
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    // 配置织入点
    @Pointcut("@annotation(com.imooc.annotation.Log)")
    public void logPointCut() {
    }

    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("执行-----LogAspect----doAround-----");
        return pjp.proceed();
    }

    @Before(value = "logPointCut()")
    public void doBefore() {
        log.info("----LogAspect----doBefore-----------------记录日志");
    }

    @After(value = "logPointCut()")
    public void doAfter() {
        log.info("----LogAspect----doAfter-----------------记录日志");
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        log.info("----LogAspect----doAfterReturning-----------------记录日志");
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("----LogAspect----doAfterThrowing-----------------记录日志");
    }


}
