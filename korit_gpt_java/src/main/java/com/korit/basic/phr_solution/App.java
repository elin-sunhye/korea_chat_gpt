package com.korit.basic.phr_solution;

/*
 * ======== 개인 건강 기록 (PHR: Personal Health Record) 솔루션 ========
 * 1. 프로젝트 개요
 * : 개인 건강 기록 (PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
 *   - 환자의 기본 정보를 관리, 환자의 건강 기록을 등록, 수정, 조회 가능
 *   - 특정 조건에 맞는 건강 기록을 필터링하고 집계하는 기능을 제공
 *
 * 2. 주요 기능 및 비즈니스 로직
 * : 환자 정보 관리
 *   - CR(전체, 단건)UD
 * : 건강 기록 관리
 *   - CRUD + 필터링(조회)
 *
 * 3. 비즈니스 로직 구조
 * - Controller: 사용자의 입력을 처리하고 적절한 서비스 메소드를 호출
 * - Service: 핵심 비즈니스 로직을 수행
 * - Repository: 데이터 저장소와의 상호 작용을 담당 (싱글톤패턴)
 * - DTO: 계층 간 데이터 전송을 위한 객체
 * - Entity: 데이터베이스 테이블과 매핑되는 도메인 객체
 *
 * 4. 실행 및 관리
 * - Main Class (App.java): 프로그램의 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 * */

import com.korit.basic.phr_solution.controller.PatientController;
import com.korit.basic.phr_solution.controller.RecordController;
import com.korit.basic.phr_solution.dto.request.PatientRequestDto;
import com.korit.basic.phr_solution.dto.request.RecordRequestDto;
import com.korit.basic.phr_solution.dto.response.PatientResponseDto;
import com.korit.basic.phr_solution.dto.response.RecordResponseDto;
import com.korit.basic.phr_solution.entity.HealthRecord;
import com.korit.basic.phr_solution.entity.Patient;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientController patientController = new PatientController();
    private static final RecordController recordController = new RecordController();

    public static void main(String[] args) {
        try {
            while (true) {
                displayMenu(); // 프로그램 메뉴에 대한 출력
                int choice = getChoice(); // 스태너로부터 사용자의 메뉴 선택 저장

                if (!processChoice(choice)) break; // 사용자의 종료 선택을 처리 (처리의 반환값이 falsed이면 while문 종료)
            }
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() {
        System.out.println("\n[ 메뉴 선택 ]");

        System.out.println("1. 환자 등록");
        System.out.println("2. 환자 정보 조회");
        System.out.println("3. 환자 정보 단건 조회");
        System.out.println("4. 환자 정보 수정");
        System.out.println("5. 환자 정보 삭제");

        System.out.println("6. 건강 기록 추가");
        System.out.println("7. 건강 기록 조회");
        System.out.println("8. 건강 기록 필터링 및 집계");
        System.out.println("9. 건강 기록 삭제");

        System.out.println("10. 종료");
        System.out.print("메뉴 선택 >> ");
    }

    private static int getChoice() {
//        숫자 받을 때까지 계속 반복
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next(); // 버퍼 처리
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // 버퍼처리

        return choice;
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            // 회원 관련 기능
            case 1: {
//                환자 등록 : 이름, 나이, 성별
                PatientRequestDto requestDto = createPatientRequest();
                patientController.registerPatient(requestDto);
//                System.out.println("환자 정보가 등록 되었습니다.");

                break;
            }
            case 2: {
//                환자 정보 조회
                List<PatientResponseDto> patients = patientController.getAllPatients();

                if (patients.isEmpty()) {
                    System.out.println("환자 정보가 없습니다.");
                } else {
                    patients.forEach(System.out::println);
                }

                break;
            }
            case 3: {
//                환자 정보 단건 조회 : 환자 고유 번호
                long id = getIdInput();
                PatientResponseDto patient = patientController.getPatientById(id);

                if (patient == null) {
                    System.out.println("해당하는 ID의 환자가 없습니다.");
                } else {
                    System.out.println(patient);
                }


                break;
            }
            case 4: {
//                환자 정보 수정 : 환자 고유 번호, 수정 할 데이터(이름, 나이, 성별)
                long id = getIdInput();
                PatientRequestDto requestDto = createPatientRequest();
                patientController.updatePatient(id, requestDto);
//                System.out.println("환자 정보가 수정 되었습니다.");

                break;
            }
            case 5: {
//                환자 정보 삭제 : 환자 고유 번호
                long id = getIdInput();
                patientController.deletePatient(id);
//                System.out.println("환자가 삭제 되었습니다.");

                break;
            }

//            건강 기록 관련 기능
            case 6: {
//                건강 기록 추가 : 환자 고유 번호, 방문날짜, 진단, 처방
                RecordRequestDto requestDto = createRecordRequest();
                long id = requestDto.getPatientId();
                recordController.createRecord(requestDto);
//                System.out.println(id + "번호의 환자 기록이 추가되었습니다.");

                break;
            }
            case 7: {
//                건강 기록 조회
                List<RecordResponseDto> records = recordController.getAllRecords();

                if (records.isEmpty()) {
                    System.out.println("건강 기록이 없습니다.");
                } else {
                    records.forEach(System.out::println);
                }

                break;
            }
            case 8: {
//                건강 기록 필터링 및 집계(진단명) : 진단
                String diagnosisFilter = getInput("필터 조건 (진단명) : ");
                List<RecordResponseDto> filteredRecords = recordController.filterRecordsByDiagnosis(diagnosisFilter);
                filteredRecords.forEach(System.out::println);

                break;
            }
            case 9: {
//                건강 기록 삭제 : 건강 기록 고유 번호
                long id = getIdInput();
                recordController.deleteRecord(id);
//                System.out.println("건강 기록이 삭제 되었습니다.");

                break;
            }
            case 10: {
                System.out.println("=== 종료합니다. 이용해 주셔서 감사합니다 :) ===");
                scanner.close();
                return false;
            }
            default: {
                System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");
                break;
            }
        }
        return true;
    }

    private static long getIdInput() {
//        Integer.parseInt(String s)
        String input = getInput("ID를 입력하세요.");
        return Long.parseLong(input);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    private static PatientRequestDto createPatientRequest() {
        PatientRequestDto dto = null;

        try {
            String name = getInput("환자 이름을 입력하세요");
            int age = Integer.parseInt(getInput("환자 나이를 입력하세요"));
            String gender = getInput("환자 성별을 입력하세요 (남/여)");

            dto = new PatientRequestDto(name, age, gender);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


        return dto;
    }

    private static RecordRequestDto createRecordRequest() {
        RecordRequestDto dto = null;
        try {
            long patientId = getIdInput();
            String dateOfVisit = getInput("방문 날짜를 입력하세요 (YYYY-mm-DD)");
            String diagnosis = getInput("진단명을 입력하세요.");
            String treatment = getInput("처방 내용을 입력하세요.");

            dto = new RecordRequestDto(patientId, dateOfVisit, diagnosis, treatment);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return dto;
    }
}
