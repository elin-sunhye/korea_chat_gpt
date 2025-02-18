package com.korit.basic.chapter16.practice.service;

import com.korit.basic.chapter16.practice.entity.Category;
import com.korit.basic.chapter16.practice.entity.Item;

import java.util.List;

// 4

public interface Manageable {
    List<Item> searchByCategory(Category category);
}
