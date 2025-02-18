package com.korit.korit_gpt_java_springboot.entity.study;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {
    private int instructorId;
    private String instructorName;
}
