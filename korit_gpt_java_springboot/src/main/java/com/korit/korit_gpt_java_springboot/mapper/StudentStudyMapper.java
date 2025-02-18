package com.korit.korit_gpt_java_springboot.mapper;

import com.korit.korit_gpt_java_springboot.entity.study.Instructor;
import com.korit.korit_gpt_java_springboot.entity.study.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentStudyMapper {
//    학과 전체 조회
    List<Major> selectMajorsAll();

//    교수 전체 조회
    List<Instructor> selectInstructorsAll();

//    insert, delete, update는 성공건수가 리턴값이 된다
//    학과 추가
    int insertMajor(Major major);

//    교수 추가
    int insertInstructor(Instructor instructor);

//    학과 수정
    int updateMajorName(Major major);
}
