package com.korit.servlet_study.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ElementType: 클래스에 달 수 잇는 어노테이션
// ElementType.METHOD : 클래스, 메서드 위에 달 수 있는 어노테이션
@Target({ElementType.METHOD})
// 어노테이션 적용 시점
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtValid {
}
