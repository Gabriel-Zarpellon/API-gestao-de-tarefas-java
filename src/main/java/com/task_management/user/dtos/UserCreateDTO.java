package com.task_management.user.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreateDTO {
    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "E-mail is required.")
    @Email(message = "E-mail is invalid.")
    private String email;

    @NotBlank(message = "Name is required.")
    @Length(min = 8, message = "Password must be at least 8 characters long.")
    private String password;
}
