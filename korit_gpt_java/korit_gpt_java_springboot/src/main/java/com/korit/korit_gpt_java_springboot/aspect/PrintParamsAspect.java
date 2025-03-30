package com.korit.korit_gpt_java_springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintParamsAspect {
//    log4j2
    private static final Logger log = LoggerFactory.getLogger(PrintParamsAspect.class);

    @Pointcut("@annotation(com.korit.korit_gpt_java_springboot.aspect.annotation.PrintParamsAop)")
    private void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//    joinPoint 안에 해당 메소드의 데이터들이 다 있음
//        CodeSignature로 다운캐스팅
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        log.error("로그를 출력합니다.");

        for(int i = 0; i < parameterNames.length; i++) {
            System.out.println(parameterNames[i] + ": " + args[i]);
        }

        Object result = joinPoint.proceed();

        return result;
    }
}
