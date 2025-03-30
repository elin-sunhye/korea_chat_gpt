package com.korit.basic.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    === 직원 관리 시스템 ===
 */
// 2. 직원 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private double salary;
}

public class I_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승아", 5000),
                new Employee("HR", "조승범", 7000),
                new Employee("IT", "김준일", 6500),
                new Employee("Finance", "전예찬", 4000),
                new Employee("HR", "윤대휘", 6300)
        );

//        1. 급여가 6000 이상인 직원 필터링
        List<Employee> salaryEmp = employees.stream()
                .filter(salary -> salary.getSalary() >= 6000)
                .collect(Collectors.toList());
        System.out.println("급여가 6000 이상인 직원 : ");
        salaryEmp.forEach(System.out::println);

        System.out.println();

//        2. IT 부서 직원의 이름만 추출
        List<String> names = employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("IT 부서 직원 : ");
        System.out.println(names);

        System.out.println();

//        3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        List<Employee> nameWidthJo = employees.stream()
//                .filter(employee -> employee.getDepartment().equals("HR") && employee.getName().contains("조"))
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());
        System.out.println("특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 : ");
        nameWidthJo.forEach(System.out::println);

//        4. 부서별 직업 그룹화
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("부서별 직업 그룹화 : ");
        System.out.println(employeesByDept);

//        5. 부서별 평균 급여 계산
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        Map<String, Double> avgSalaryByDept2 = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.averagingDouble(employee -> employee.getSalary())));
        System.out.println("부서별 평균 급여 : ");
        System.out.println(avgSalaryByDept);
    }
}
