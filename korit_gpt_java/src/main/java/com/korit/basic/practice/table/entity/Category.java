package com.korit.basic.practice.table.entity;

public enum Category {
    /**
     * @MENU 메뉴에 대한 질문
     * @LOGIN 로그인에 대한 질문
     * @FUNCTION 기능에 대한 질문
     */
    MENU, LOGIN, FUNCTION;

    public static Category fromString(String value) {
        try {
//            이넘에 맞게 입력이 되었다면 입력 받은 문자열을 전부 대문자로 바꿔라
            return Category.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
//            이넘에 맞게 입력이 되지 않았다면 예외 발생해라
            throw new IllegalArgumentException("Invalid category : " + value);
        }
    }
}
