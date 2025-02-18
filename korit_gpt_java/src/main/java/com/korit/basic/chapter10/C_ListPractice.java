package com.korit.basic.chapter10;

/*
    === 이벤트 관리 시스템 ===
    - 이벤트 참가자 명단과 대기열 관리를 위한 시스템
    - 참가자는 사전 등록된 명단을 통해 이벤트에 참가
    - 명단이 꽉 차면 대기열로 추가, 참가자가 ㄸ나면 대기열에 다음 사람이 추가

    1) 이벤트 참가자 명단 관리
    : 사전에 등럭, 이벤트 당일에는 추가적인 참가자 등록 X
    >> ArrayList (목록 추가, 삭제 X / 참자가 조회 O)

    2) 대기열 관리
    : 이벤트에는 한정된 좌석, 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록
    >> LinkedList (목록추가, 삭제 O / 참가자 조회 O)
 */

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    //    == 필드 ==
//    이벤트 참가자 명단
    ArrayList<String> participantList = new ArrayList<>();
    //    대기열 명단
    LinkedList<String> waitingQueue = new LinkedList<>();

    //    == 메서드 ==
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        if (waitingQueue.size() > 0) {
            String nextParticipant = waitingQueue.remove(0);
            addParticipant(nextParticipant);
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("김선혜");
        eventManagement.addParticipant("김다혜");
        eventManagement.addParticipant("안형우");
        eventManagement.addParticipant("복숭아");
        eventManagement.addParticipant("김김김");

        eventManagement.addToWaitingQueue("윤대휘");
        eventManagement.addToWaitingQueue("김소빈");
        eventManagement.addToWaitingQueue("정규민");
        eventManagement.addToWaitingQueue("박성욱");

        System.out.println(eventManagement.participantList);
        System.out.println(eventManagement.waitingQueue);

        eventManagement.leaveParticipant("김김김");
        System.out.println(eventManagement.participantList);

        eventManagement.leaveParticipant("복숭아");
        System.out.println(eventManagement.participantList);

        System.out.println(eventManagement.checkParticipant("안형우"));
        System.out.println(eventManagement.checkParticipant("박성욱"));

        System.out.println(eventManagement.waitingQueue);
    }
}
