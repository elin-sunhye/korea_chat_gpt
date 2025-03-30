package com.korit.basic.chapter16.practice;

import com.korit.basic.chapter16.practice.entity.Category;
import com.korit.basic.chapter16.practice.entity.Item;
import com.korit.basic.chapter16.practice.service.LibraryManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// chapter 13 - practice (도서 관리 시스템에 enum 자료형 사용 추가)
public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Library System ===");
            System.out.println("1. Search by Category");

            System.out.print("Select an option : ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                // parseInt(String s)
                switch (choice) {
                    case 1:
                        System.out.print("Enter Category");
                        String searchCategory = scanner.nextLine();
                        try {
                            Category searchCategoryEnum = Category.fromString(searchCategory);
                            List<Item> categoryResult = manager.searchByCategory(searchCategoryEnum);
                            if (categoryResult.isEmpty()) {
                                System.out.println("No items found in category : " + searchCategoryEnum);
                            } else {
                                categoryResult.forEach(Item::display);
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            } catch (NumberFormatException e) {
//                serr : 인자 내의 문자열을 오류로 인식하고 출력
                System.err.println("Please enter a valid number");
            } catch (NoSuchElementException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
