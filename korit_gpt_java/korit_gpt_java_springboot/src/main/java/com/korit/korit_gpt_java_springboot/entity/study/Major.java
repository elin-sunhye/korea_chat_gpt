package com.korit.korit_gpt_java_springboot.entity.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major {
    private int majorId;
    private String majorName;
}
