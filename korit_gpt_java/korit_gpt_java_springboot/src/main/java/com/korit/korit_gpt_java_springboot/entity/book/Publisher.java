package com.korit.korit_gpt_java_springboot.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    private int publisherId;
    private String publisherName;
}
