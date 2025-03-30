package com.korit.basic.phr_solution.entity;

import lombok.Data;
import lombok.AllArgsConstructor;

// 환자 기록

@Data
@AllArgsConstructor
public class Patient {
    private Long id; // 환자의 고유 번호
    private String name;
    private int age;
    private String gender;
}
