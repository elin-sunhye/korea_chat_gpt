package com.korit.springboot_security.mapper.user;

import com.korit.springboot_security.entity.user.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int insertAll(List<Role> roles);
}
