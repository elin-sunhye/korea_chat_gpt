package com.korit.basic.chapter07.animalApp;

/*
     === 동물 관리 시스템 ===
 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
//        === 서비스 계층 생성 ===
        AnimalService service = new AnimalService();

//        동물을 관리하는 List 생성
        ArrayList<Animal> animals = new ArrayList<>();

//        동적 배열에 객체 추가 - 업캐스팅
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

//        동적 배열의 모든 동물들을 service로 처리
        for (Animal animal : animals) {
            service.handleAnimal(animal);
        }

//        객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

//        cat.eat();
        if (cat instanceof Cat) {
//        cat.eat(); - Animal 타입 이기때문에 오류!
            Cat onlyCat = (Cat) cat; // 다운 캐스팅 : 해당 클래스가 가진 고유 멤버에 접근 가능
            onlyCat.eat();
        }


    }
}
