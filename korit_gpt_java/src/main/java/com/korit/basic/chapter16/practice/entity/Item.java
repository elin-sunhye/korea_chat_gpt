package com.korit.basic.chapter16.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 2

@AllArgsConstructor
@Getter
public abstract class Item {
    private String id;
    private String name;

    public abstract void display();
}