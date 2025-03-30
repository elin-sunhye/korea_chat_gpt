package com.korit.korit_gpt_java_springboot.controller;

import com.korit.korit_gpt_java_springboot.dto.request.study.ReqAddStudentDto;
import com.korit.korit_gpt_java_springboot.dto.request.study.ReqStudentDto;
import com.korit.korit_gpt_java_springboot.dto.response.study.RespAddStudentDto;
import com.korit.korit_gpt_java_springboot.dto.response.study.RespStudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // @ResponseBody 대신 사용 but MVC X
//@Controller
@Api(tags = "REST API class")
public class FirstRestController {

    //    @ResponseBody // html 파일 응답 아니고, 데이터 응답
    @GetMapping("/api/hello")
    public Map<String, Object> hello(HttpServletRequest req) {
        String age = req.getParameter("age");
        String address = req.getParameter("address");

        System.out.println("age : " + age);
        System.out.println("address : " + address);

        return Map.of("name", "김선혜");
    }

    @GetMapping("/api/hello2")
    public Map<String, Object> hello2(@RequestParam(name = "age") int age, @RequestParam(name = "address") String address) {

        System.out.println("age : " + age);
        System.out.println("address : " + address);

        return Map.of("name", "김선혜");
    }

    @ApiOperation(value = "학생 조회 (일반 for문 선형탐색)", notes = "일반 for 문을 사용하여 선형 탐색 학습")
    //    /api/student?id=1
    @GetMapping("/api/student")
    public Map<String, Object> getStudent(
            @ApiParam(value = "학생 ID")
            @RequestParam(required = false) int id) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 1, "name", "김선혜", "age", 30));
        students.add(Map.of("id", 2, "name", "안형우", "age", 35));
        students.add(Map.of("id", 3, "name", "김다혜", "age", 34));

        int foundStudentIdx = -1;
        for (int i = 0; i < students.size(); i++) {
//            if(i == (id - 1)) {
            if ((Integer) students.get(i).get("id") == id) {
                foundStudentIdx = i;
                break;
            }
        }

        if (foundStudentIdx == -1) {
            return Map.of("error", "Not found student");
        }

        return students.get(foundStudentIdx);
    }

    @GetMapping("/api/student2")
    @ApiOperation(value = "학생 조회 (향상된 for 문을 사용하여 선형 탐색 학습)")
    public Map<String, Object> getStudent2(
            @ApiParam(value = "조회 학생 ID")
            @RequestParam int id) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 1, "name", "김선혜2", "age", 30));
        students.add(Map.of("id", 2, "name", "안형우2", "age", 35));
        students.add(Map.of("id", 3, "name", "김다혜2", "age", 34));

        Map<String, Object> foundStudent = null;
        for (Map<String, Object> student : students) {
            if ((Integer) student.get("id") == id) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            return Map.of("Error", "Not found");
        }

        return foundStudent;
    }

    @ApiOperation(value = "학생 조회 (stream()을 사용하여 선형 탐색 조회 학습)")
    @GetMapping("/api/student3")
    public Map<String, Object> getStudent3(
            @ApiParam(value = "조회할 학생 ID")
            @RequestParam int id) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 1, "name", "김선혜3", "age", 30));
        students.add(Map.of("id", 2, "name", "안형우3", "age", 35));
        students.add(Map.of("id", 3, "name", "김다혜3", "age", 34));

        Map<String, Object> respData = students.stream()
                .filter(student -> (Integer) student.get("id") == id)
                .findFirst()
                .orElse(Map.of("Error", "Not found"));

        return respData;
    }

    @ApiOperation(value = "학생 상세 조회 (동적)")
    @GetMapping("/api/student4/{id}")
    public RespStudentDto getStudent4(
            @ApiParam(value = "학생 ID")
            @PathVariable int id,
            ReqStudentDto reqStudentDto
    ) {
//        return Map.of("id", id, "name", reqStudentDto.getName(), "age", reqStudentDto.getAge())
        return new RespStudentDto(100, reqStudentDto.getName(), reqStudentDto.getAge());
    }

    @PostMapping("/api/student")
    @ApiOperation(value = "학생 추가", notes = "학생 정보를 입력받아 학생 정보 저장")
    public ResponseEntity<RespAddStudentDto> addStudent(@RequestBody ReqAddStudentDto reqAddStudentDto) {
        System.out.println(reqAddStudentDto);

        return ResponseEntity.ok().body(new RespAddStudentDto("학생 추가 완료", true));
    }

    @PutMapping("/api/student/{id}")
    @ApiOperation(value = "학생 정보 수정", notes = "학생 ID를 기준으로 학생 정보 수정")
    public ResponseEntity<?> updateStudent(
            @ApiParam(value = "학생 ID", example = "1", required = true)
            @PathVariable int id,
            @RequestBody Map<String, Object> reqBody) {
        System.out.println(reqBody);

        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/api/student/{id}")
    @ApiOperation(value = "학생 정보 삭제", notes = "학생 ID를 기준으로 학생 삭제")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok().body(null);
    }
}
