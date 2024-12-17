package com.task_management.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_management.user.dtos.UserCreateDTO;
import com.task_management.user.dtos.UserReturnDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<UserReturnDTO> create(@Valid @RequestBody UserCreateDTO data) {
        UserEntity user = new UserEntity();
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());

        UserEntity newUser = userService.create(user);

        UserReturnDTO response = modelMapper.map(newUser, UserReturnDTO.class);

        return ResponseEntity.status(201).body(response);
    }
}
