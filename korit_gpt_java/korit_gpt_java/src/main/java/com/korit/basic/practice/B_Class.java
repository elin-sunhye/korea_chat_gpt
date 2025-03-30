package com.korit.basic.practice;

class Tv {
    static boolean isPower = false;
    int channelNum = 0;


    void channelUp() {
        if (isPower) {
            ++channelNum;
        } else {
            System.out.println("전원을 켜주세요.");
        }
    }

}

class SmartTv extends Tv {
    String ott;

    SmartTv(String ott) {
        if (isPower) {
            this.ott = ott;
            System.out.println("OTT 실행");
        } else {
            System.out.println("전원이 꺼져있어 OTT 실행이 불가능합니다.");
        }
    }
}

public class B_Class {
    public static void main(String[] args) {
        Tv tv = new Tv();

        tv.channelUp();
        Tv.isPower = true;

        tv.channelUp();
        tv.channelUp();
        tv.channelUp();

        System.out.println(tv.channelNum);
        Tv.isPower = true;

        SmartTv smTv = new SmartTv("Tving");
        Tv.isPower = false;
        new SmartTv("a");
    }
}
