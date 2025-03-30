package com.korit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
    클래스에 제너릭 설정하는 것이 보통
    그러나 static은 생성 없이 바로 사용 가능하기 때문에
    반환 자료형 앞에 제네릭 설정
 */
public class ForEachPrinter2 {
    public static <T> void print(T[] array) {
        for (T data : array) {
            System.out.println(data);
        }
    }

//    스테틱 제네릭 반환 타입
    public static <T> List<T> printR(List<T> datas, Consumer<List<T>> action) {
        List<T> result = new ArrayList<>();

        action.accept(datas);

        return result;
    }

    /*
    public static void print(Object[] array) {
        for (Object data : array) {
            System.out.println(data);
        }
    }
    : 다양한 타입을 받으려면 이렇게도 사용 가능하나 굳이 제네릭을 사용하는 이유 ?
    -> Object 타입으로 지정하면 업캐스팅이 되어서 하위 메서드를 사용하려면 다운캐스팅을 해여하야는데 그 번거러움을 줄이기 위해
    */
}
