package com.korit.korit_gpt_java_springboot.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    private int userRoleId;
    private int userId;
    private int roleId;

    private Role role;
}
