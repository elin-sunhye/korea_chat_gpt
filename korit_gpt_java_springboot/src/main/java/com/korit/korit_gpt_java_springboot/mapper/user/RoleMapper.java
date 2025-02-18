package com.korit.korit_gpt_java_springboot.mapper.user;

import com.korit.korit_gpt_java_springboot.entity.user.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int insertAll(List<Role> roles);
}
