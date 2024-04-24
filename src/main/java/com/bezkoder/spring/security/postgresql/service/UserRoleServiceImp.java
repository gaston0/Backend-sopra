package com.bezkoder.spring.security.postgresql.service;

import com.bezkoder.spring.security.postgresql.models.Role;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserRoleServiceImp implements UserRoleService{

    private final UserRepository userRepository;

    @Autowired
    public UserRoleServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<Role> getUserRoles(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new HashSet<>(user.getRoles());
        } else {
            throw new IllegalArgumentException("Utilisateur non trouvé avec l'identifiant: " + userId);
        }
    }
}
