package com.korit.boardback.mapper;

import com.korit.boardback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectByUserId(int userId);
    User selectByUsername(String username);
    int insert(User user);

    int updateProfileImgByUserId(
            @Param("userId") int userId,
            @Param("profileImg") String profileImg
    );

    int updateNicknameByUserId(
            @Param("userId") int userId,
            @Param("nickname") String nickname
    );

    int updatePasswordByUserId(
            @Param("userId") int userId,
            @Param("password") String password
    );
}
