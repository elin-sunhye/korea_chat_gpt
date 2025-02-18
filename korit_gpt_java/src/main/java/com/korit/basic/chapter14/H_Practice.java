package com.korit.basic.chapter14;
// === 컬렉션 프레임 워크 & 스트림 API & 람다 표현식 & 메서드 참조 ===
//스트림 API : 데이터를 새롭게 만들어 줌

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. 학생 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;
}

public class H_Practice {
    public static void main(String[] args) {
//        == 1. 학생 목록 필터링 & 정렬 ==
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("이승아", 29, 4.3),
                new StudentClass("이도경", 33, 4.1),
                new StudentClass("이지훈", 20, 3.8),
                new StudentClass("이지희", 25, 3.5)
        );

//          1-1. 학점이 4.0 이상인 학생 필터링
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());
        System.out.println("학점이 4.0 이상인 학생 : ");
        filteredStudents.forEach(System.out::println);

//          1-2. 학생 이름 목록만 추출
        List<String> studentNames = studentClasses.stream()
//                .map(student -> student.getName())
                .map(StudentClass::getName)
                .collect(Collectors.toList());
        System.out.println("학생 이름 목록 : ");
        System.out.println(studentNames);

//          1-3. 점수순 정렬
        List<StudentClass> sortedStudents = studentClasses.stream()
//                컬렉션 프레임워크의 중간 연산 : sorted(정렬)
//                Comparator 클래스의 .comparingDouble 정적 메서드 활용
//                : 실수값들에 대한 비교
//                : studentClass::getGrade
                .sorted(Comparator.comparingDouble(StudentClass::getGrade))
//                .sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed())
                .collect(Collectors.toList());
        System.out.println("점수순 정렬 : ");
        sortedStudents.forEach(System.out::println);

//          1-4. '지' 단어가 이름에 포함된 학생 필터링
        List<StudentClass> studentWithJi = studentClasses.stream()
                .filter(student -> student.getName().contains("지"))
                .collect(Collectors.toList());
        System.out.println("'지'가 포함된 이름 : ");
        studentWithJi.forEach(System.out::println);
    }
}
