package com.korit.basic.chapter17.entity;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

import java.util.Date;

// 2

@RequiredArgsConstructor
@Getter
public class Reservation {
    //    각 예약이 가지는 고유한 id 값
    private final String reservationId;

    // 예약자 정보
    private final String userId;
    //    private final String reservationTime;
    private final Date reservationTime;

    //    초기값 설정
//    : 해당 에약의 활성화 상태 저장
//    - true : 예약 완료
//    - false : 예약 취소
    private boolean isActive = true;

    public void cancel() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        String isActiveMessage = isActive ? "예약 중" : "예악 취소";

        return "[ 예약 ID : " + reservationId + ", 사용자 ID : " + userId + ", 예약일자 : " + reservationTime + " , 예약 상태 : " + isActiveMessage + " ]";
    }
}