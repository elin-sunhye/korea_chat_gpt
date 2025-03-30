package com.korit.basic.chapter17.service;

import com.korit.basic.chapter17.entity.Reservation;
import com.korit.basic.chapter17.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    //    private final ReservationRepository reservationRepository = new ReservationRepository();


    //    생성자 주입 방식 권장
    private final ReservationRepository reservationRepository;
    private final UserServiceImpl userServiceImpl;

    public ReservationServiceImpl(UserServiceImpl userServiceImpl) {
        this.reservationRepository = new ReservationRepository();
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void createReservation(String reservationId, String userId) {
        if (userServiceImpl.isLoggedIn()) {
            Date reservationTime = new Date();
            Reservation newReservation = new Reservation(reservationId, userId, reservationTime);
            reservationRepository.save(newReservation);
            System.out.println("예약 완료 : " + reservationTime);
        } else {
            System.out.println("로그인이 필요한 기능입니다.");
        }
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        if (reservations.isEmpty()) {
            System.out.println(userId + "님의 예약 내역이 없습니다.");
        }
        return reservations;
    }

    @Override
    public void cancelReservation(String reservationId) {
        reservationRepository.findById(reservationId).ifPresentOrElse(
//        reservationId에 잂치하는 에약이 존재 -> 삭제
//        reservation -> reservation.cancel()
                Reservation::cancel
                , () -> System.out.println("해당 예약 ID를 찾을 수 없습니다."));
    }
}
