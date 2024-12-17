package com.task_management.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity create(UserEntity data) {
        return userRepository.save(data);
    }
}
