package com.korit.korit_gpt_java_springboot.service;

import com.korit.korit_gpt_java_springboot.dto.request.study.ReqAddInstructorDto;
import com.korit.korit_gpt_java_springboot.dto.request.study.ReqAddMajorDto;
import com.korit.korit_gpt_java_springboot.dto.request.study.ReqUpdateMajorDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.study.Instructor;
import com.korit.korit_gpt_java_springboot.entity.study.Major;
import com.korit.korit_gpt_java_springboot.repository.StudentStudyRepository;

import org.apache.ibatis.javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// 백앤드 개발자에서 나는 오류 처리

@Service
public class StudentStudyService {

    @Autowired
    private StudentStudyRepository studentStudyRepository;

//    학과 전체 조회
    public SuccessResponseDto<List<Major>> getMajorsAll() throws NotFoundException {
//        try catch -> controllerAdvice®로 경로 변경 해야하는데 try catch 하면 기존 controller로 감
        List<Major> foundMajors = studentStudyRepository.findMajorAll()
                .orElseThrow(() -> new NotFoundException("Not Found majors"));
        return new SuccessResponseDto<>(foundMajors);
    }

//    교수 전체 조회
    public SuccessResponseDto<List<Instructor>> getInstructorsAll() throws NotFoundException {
        return new SuccessResponseDto<>(studentStudyRepository.findInstructorAll()
                .orElseThrow(() -> new NotFoundException("Not Found instructors"))
        );
    }

//    학과 추가
    @Transactional(rollbackFor = Exception.class) // insert, delete, update 필수 조건
    public SuccessResponseDto<Major> addMajor(ReqAddMajorDto reqAddMajorDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                studentStudyRepository.saveMajor(
                        new Major(0, reqAddMajorDto.getMajorName())
                ).orElseThrow()
        );

    }

//    교수 추가
    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Instructor> addInstructor(ReqAddInstructorDto reqAddInstructorDto) throws DuplicateKeyException {
        Instructor foundInstructor = studentStudyRepository.saveInstructor(
                new Instructor(0, reqAddInstructorDto.getInstructorName())
        ).get();
        return new SuccessResponseDto<>(foundInstructor);
    }

//    학과 수정
    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Major> modifyMajor(int majorId, ReqUpdateMajorDto reqUpdateMajorDto) throws NotFoundException, DuplicateKeyException {
        Major foundMajor = studentStudyRepository.updateMajor(
                new Major(majorId, reqUpdateMajorDto.getMajorName())
        ).orElseThrow(() -> new NotFoundException("Not Found Major Id"));
        return new SuccessResponseDto<>(foundMajor);
    }
}
