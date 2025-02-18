package com.korit.basic.chapter13;

import lombok.Getter;
import lombok.Setter;

/*
    === gradle 빌드 도구에 lombok 라이브러리 설치 ===
    확장 프로그램 설치 > build.gradle 파일에 코드 추가 (// https://mvnrepository.com/artifact/org.projectlombok/lombok)
*/


@Getter
@Setter
class LombokExample {
    private String name;
    private int age;

//    public void setName(String name) {
//        this.name = name;
//    }
}

public class G_Lombok {
    public static void main(String[] args) {
        LombokExample lombokExample = new LombokExample();
        lombokExample.setName("aaa");
        lombokExample.setAge(23);

        System.out.println(lombokExample.getName());
        System.out.println(lombokExample.getAge());
    }
}
