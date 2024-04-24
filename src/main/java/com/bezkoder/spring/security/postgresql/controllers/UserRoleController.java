package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Role;
import com.bezkoder.spring.security.postgresql.service.UserRoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {
    private final UserRoleServiceImp userRoleService;
    @Autowired
    public UserRoleController(UserRoleServiceImp userRoleService) {
        this.userRoleService = userRoleService;
    }
    @GetMapping("/{userId}")

    public Set<Role> getUserRoles(@PathVariable Long userId) {
        return userRoleService.getUserRoles(userId);
    }
}
