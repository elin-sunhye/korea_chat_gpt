package com.korit.basic.phr_solution.controller;

import com.korit.basic.phr_solution.dto.request.PatientRequestDto;
import com.korit.basic.phr_solution.dto.response.PatientResponseDto;
import com.korit.basic.phr_solution.entity.Patient;
import com.korit.basic.phr_solution.service.PatientService;

import java.util.List;
// 검증만하고 바로 서비스로 보낸다

public class PatientController {
    private PatientService service;

    public PatientController() {
        service = new PatientService();
    }

    //    환자 등록
    public void registerPatient(PatientRequestDto requestDto) {
        service.registerPatient(requestDto);
    }

    //    환자 조회
    public List<PatientResponseDto> getAllPatients() {
        List<PatientResponseDto> patients = service.listAllPatients();
        return patients;
    }

    //    환자 단건 조호
    public PatientResponseDto getPatientById(long id) {
        PatientResponseDto patient = service.getPatientById(id);
        return patient;
    }

    //    환자 정보 수정
    public void updatePatient(long id, PatientRequestDto requestDto) {
        service.updatePatient(id, requestDto);
    }

    //    환자 삭제
    public void deletePatient(long id) {
        service.deletePatient(id);
    }
}
