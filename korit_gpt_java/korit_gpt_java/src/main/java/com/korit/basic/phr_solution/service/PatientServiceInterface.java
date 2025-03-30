package com.korit.basic.phr_solution.service;

import com.korit.basic.phr_solution.dto.request.PatientRequestDto;
import com.korit.basic.phr_solution.dto.response.PatientResponseDto;

import java.util.List;

public interface PatientServiceInterface {
    void registerPatient(PatientRequestDto requestDto);

    List<PatientResponseDto> listAllPatients();

    PatientResponseDto getPatientById(Long id);

    void updatePatient(Long id, PatientRequestDto requestDto);

    void deletePatient(Long id);
}
