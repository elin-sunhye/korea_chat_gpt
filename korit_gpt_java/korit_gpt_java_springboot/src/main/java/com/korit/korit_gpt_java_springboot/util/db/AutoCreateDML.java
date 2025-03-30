package com.korit.korit_gpt_java_springboot.util.db;

import com.korit.korit_gpt_java_springboot.entity.user.Role;
import com.korit.korit_gpt_java_springboot.mapper.user.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutoCreateDML implements CommandLineRunner {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void run(String... args) throws Exception {
//        insertRole();
    }

    private void insertRole() {
        List<String> roleNames = List.of("USER", "ADMIN", "MANAGER");
        roleMapper.insertAll(roleNames.stream()
                .map(name-> Role.builder().roleName("ROLE_" + name).build())
                .collect(Collectors.toList())
        );
    }
}
