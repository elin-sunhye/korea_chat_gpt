package com.korit.korit_gpt_java_springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAspect {

//    위치
    @Pointcut("execution(* com.korit.korit_gpt_java_springboot.service.post.PostService.getPostById(..))")
    private void executionPointCut() {}

    @Pointcut("@annotation(com.korit.korit_gpt_java_springboot.aspect.annotation.TimerAop)")
    private void annotationPointCut() {}

//    해당 위치에서 실행
//    @Around(
//      "execution(* com.korit.korit_gpt_java_springboot.service.post.PostService.getPostById(..))
//      || @annotation(com.korit.korit_gpt_java_springboot.aspect.annotation.TimerAop)"
//    )
    @Around("executionPointCut() || annotationPointCut()")
//    joinPoint = com.korit.korit_gpt_java_springboot.service.post.PostService.getPostById(..)
    public Object around (ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("method runtime" + stopWatch.getTotalTimeSeconds());
//        return 안해주면 controller로 안 넘어감
        return result;
    }

}