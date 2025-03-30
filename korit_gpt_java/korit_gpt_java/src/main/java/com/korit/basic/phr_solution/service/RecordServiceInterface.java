package com.korit.basic.phr_solution.service;

import com.korit.basic.phr_solution.dto.request.RecordRequestDto;
import com.korit.basic.phr_solution.dto.response.RecordResponseDto;

import java.util.List;

public interface RecordServiceInterface {
    void createRecord(RecordRequestDto requestDto);

    List<RecordResponseDto> getAllRecords();

    List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosis);

    void deleteRecord(long id);
}
