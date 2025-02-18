package com.korit.korit_gpt_java_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
// private static final Logger log = LoggerFactory.getLogger(PrintParamsAspect.class); 생략 가능
public class LoggingAspect {

    @Pointcut("execution(* com.korit.korit_gpt_java_springboot.controller.advice.*.*(..))")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Exception exception = (Exception) joinPoint.getArgs()[0];
        log.error(exception.getMessage());
        return joinPoint.proceed();
    }

}
