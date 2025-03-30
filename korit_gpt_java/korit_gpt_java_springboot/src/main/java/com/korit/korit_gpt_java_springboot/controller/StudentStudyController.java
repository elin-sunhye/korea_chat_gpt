package com.korit.korit_gpt_java_springboot.controller;

import com.korit.korit_gpt_java_springboot.dto.request.study.ReqAddInstructorDto;
import com.korit.korit_gpt_java_springboot.dto.request.study.ReqAddMajorDto;
import com.korit.korit_gpt_java_springboot.dto.request.study.ReqUpdateMajorDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.study.Instructor;
import com.korit.korit_gpt_java_springboot.entity.study.Major;
import com.korit.korit_gpt_java_springboot.service.StudentStudyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

// 사용자에서 나는 오류 처리
// 사용자 데이터를 받아서 유효성 검사를 하고 JSON을 DTO로 가공
// service에서 받은 데이터 DTO를 공통 responseDto로 가공

@Api(tags = "학생 관리 컨트롤러")
@RestController
@Validated // controller 안에서 바로 유료성 감시 시 필요
public class StudentStudyController {

    @Autowired
    private StudentStudyService studentStudyService;

    @ApiOperation(value = "학과 전체 조회 API")
    @GetMapping("/api/study/majors")
    public ResponseEntity<SuccessResponseDto<List<Major>>> getMajors() throws NotFoundException {
        return ResponseEntity.ok().body(studentStudyService.getMajorsAll());
    }

    @ApiOperation(value = "교수 전체 조회 API")
    @GetMapping("/api/study/instructors")
    public ResponseEntity<SuccessResponseDto<List<Instructor>>> getInstructor() throws NotFoundException {
        return ResponseEntity.ok().body(studentStudyService.getInstructorsAll());
    }

    @ApiOperation(value = "학과 추가 API")
    @PostMapping("/api/study/major")
    public ResponseEntity<SuccessResponseDto<Major>> addMajor(
            @Valid @RequestBody ReqAddMajorDto reqAddMajorDto
    ) throws MethodArgumentNotValidException {
        return ResponseEntity.ok().body(studentStudyService.addMajor(reqAddMajorDto));
    }

    @ApiOperation(value = "교수 추가 API")
    @PostMapping("/api/study/instructor")
    public ResponseEntity<SuccessResponseDto<Instructor>> addInstructor(@RequestBody ReqAddInstructorDto reqAddInstructorDto) {
        return ResponseEntity.ok().body(studentStudyService.addInstructor(reqAddInstructorDto));
    }

    @ApiOperation(value = "학과 수정 API")
    @PutMapping("/api/study/major/{majorId}")
    public ResponseEntity<SuccessResponseDto<Major>> updateMajor(
            @ApiParam(value = "학과 ID", example = "1", required = true)
            @PathVariable @Min(value = 1, message = "학과 ID는 1이상의 정수만 허용됩니다.") int majorId,
            @Valid @RequestBody ReqUpdateMajorDto reqUpdateMajorDto
    ) throws MethodArgumentNotValidException, NotFoundException, DuplicateKeyException {
        return ResponseEntity.ok().body(studentStudyService.modifyMajor(majorId, reqUpdateMajorDto));
    }
}
