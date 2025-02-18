package com.korit.korit_gpt_java_springboot.repository;

import com.korit.korit_gpt_java_springboot.entity.study.Instructor;
import com.korit.korit_gpt_java_springboot.entity.study.Major;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
// DB에서 나는 오류 처리

@Repository
public class StudentStudyRepository {

    @Autowired
    private StudentStudyMapper studentStudyMapper;

//    학과 전체 조회
    public Optional<List<Major>> findMajorAll(){
        List<Major> foundMajors = studentStudyMapper.selectMajorsAll();

//        List는 빈 배열이라도 null이 안 뜨기 때문에 따로 정의
        return foundMajors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundMajors);
    }

//    교수 전체 조회
    public Optional<List<Instructor>> findInstructorAll() {
        List<Instructor> foundInstructors = studentStudyMapper.selectInstructorsAll();

        return foundInstructors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundInstructors);
    }

//    학과 추가
    public Optional<Major> saveMajor(Major major) throws DuplicateKeyException {
        try{
//        중복체크
        studentStudyMapper.insertMajor(major);
        } catch (DuplicateKeyException e) {
//            insert 중 DuplicateKeyException이 났는데, 기본 메세지가 아닌 자세한 커스텀 메세지 전달을 위해 CustomDuplicateKeyException을 생성하여 에러 가로채기
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "Already exist majorName")
            );
        }
        return Optional.ofNullable(new Major(major.getMajorId(), major.getMajorName()));
    }

//    교수 추가
    public Optional<Instructor> saveInstructor(Instructor instructor) throws DuplicateKeyException {
        try {
        studentStudyMapper.insertInstructor(instructor);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("instructor", "Already exist instructorName")
            );
        }
        return Optional.ofNullable(new Instructor(instructor.getInstructorId(), instructor.getInstructorName()));
    }

//    학과 수정
    public Optional<Major> updateMajor(Major major) throws DuplicateKeyException {
        try {
            studentStudyMapper.updateMajorName(major);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "Already exist majorName")
            );
        }
        return studentStudyMapper.updateMajorName(major) < 1 ? Optional.empty() : Optional.ofNullable(major);
    }
}
