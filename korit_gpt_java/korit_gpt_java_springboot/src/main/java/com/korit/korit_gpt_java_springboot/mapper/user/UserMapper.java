package com.korit.korit_gpt_java_springboot.mapper.user;

import com.korit.korit_gpt_java_springboot.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
//    사용자 추가
    int insert (User user);

//    사용자 단건 조회 by username
    User selectByUsername(String username);

//    사용자 단건 조회 by userId
    User selectById(int userId);

//    사용자 전체 조회
    List<User> selectAllUsers();

//    사용자 수정
    int updateUserById(User user);

//    사용자 삭제
    int deleteById(int userId);
}
