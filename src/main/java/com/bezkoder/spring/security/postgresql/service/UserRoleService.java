package com.bezkoder.spring.security.postgresql.service;

import com.bezkoder.spring.security.postgresql.models.Role;

import java.util.List;
import java.util.Set;

public interface UserRoleService {

    Set<Role> getUserRoles(Long userId);
}


