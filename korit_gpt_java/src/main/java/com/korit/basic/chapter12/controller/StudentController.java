package com.korit.basic.chapter12.controller;

import com.korit.basic.chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    //    특정 학생 조회 기능 (단건 조회)
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student; // 해당 학번 학생 반환
            }
        }
        return null;
    }

    //    학생 추가 기능
    public void addStudent(String name, int age, String id) {
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("** Already added student id **");
            return;
        }
        students.add(new Student(name, age, id));
    }

    //    전체 학생 조회 기능
    public List<Student> getAllStudents() {
        return students;
    }

    //    학생 수정 기능
    public boolean updateStudent(String id, String newName, int newAge) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }

        return false;
    }

    //    학생 삭제 기능
    public boolean removeStudent(String id) {
//        for(Student student : students) {
//            if(student.getStudentId().equals(id)) {
//                students.remove(student);
//                return true;
//            }
//        }
//        return false;

        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}
