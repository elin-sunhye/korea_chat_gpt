package com.korit.basic.chapter12.view;

import com.korit.basic.chapter12.controller.StudentController;
import com.korit.basic.chapter12.model.Student;

import java.util.Scanner;

public class StudentView {
    private final Scanner scanner;
    private final StudentController controller;

    public StudentView() {
        this.scanner = new Scanner(System.in);
        this.controller = new StudentController();
    }

    public void showMenu() {
        int choice = 0;
        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add a student");
            System.out.println("2. Show all students");
            System.out.println("3. Find a student");
            System.out.println("4. Update a student");
            System.out.println("5. Delete a student");
            System.out.println("6. Quit");
            System.out.println("Choose an option >>>");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentView();
                    break;
                case 2:
                    showAllStudentView();
                    break;
                case 3:
                    findStudentView();
                    break;
                case 4:
                    updateStudentView();
                    break;
                case 5:
                    removeStudentView();
                    break;
                case 6:
                    System.out.println("=== Process Exit ===");
                    return;
            }
        }
    }

    //    학생 추가 기능
    public void addStudentView() {
        System.out.print("Enter Student Name : ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Id : ");
        String studentId = scanner.nextLine();

        controller.addStudent(name, age, studentId);
        System.out.println("Student added successfully.");
    }

    //    전체 학생 조회 기능
    public void showAllStudentView() {
//        List<Student> students = controller.getAllStudents();
        for (Student student : controller.getAllStudents()) {
            System.out.println(student.toString());
        }
    }

    //    특정 학생 조회 기능 (검색)
    public void findStudentView() {
        System.out.print("Enter student id to find : ");
        String id = scanner.nextLine();
        Student student = controller.findStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    //    학생 수정 기능
    public void updateStudentView() {
        System.out.print("Enter Student id to update : ");
        String id = scanner.nextLine();

        System.out.print("Enter new name : ");
        String newName = scanner.nextLine();

        System.out.print("Enter new age : ");
        int newAge = scanner.nextInt();
        scanner.nextLine();


        if (controller.updateStudent(id, newName, newAge)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found");
        }
    }

    //    학생 삭제 기능
    public void removeStudentView() {
        System.out.print("Enter student id to remove : ");
        String id = scanner.nextLine();

        if (controller.removeStudent(id)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found");
        }
    }
}
