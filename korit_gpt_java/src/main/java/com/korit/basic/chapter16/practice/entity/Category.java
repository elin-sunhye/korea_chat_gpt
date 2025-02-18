package com.korit.basic.chapter16.practice.entity;

// 1
public enum Category {
    FICTION,
    NONFICTION,
    SCIENCE,
    HISTORY,
    FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category : " + value);
        }
    }
}
