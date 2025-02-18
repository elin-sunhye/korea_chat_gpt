package com.korit.basic.chapter12.model;

public class Student {
    private String name;
    private int age;
    private String studentId;

    //    초기화
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    //    getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    //    setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentId() {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "[ NAME: " + name + ", AGE : " + age + ", STUDENT ID : " + studentId + " ]";
    }

}
