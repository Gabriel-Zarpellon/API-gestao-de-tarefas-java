package com.task_management.user.dtos;

import java.util.List;

import com.task_management.task.TaskEntity;

import lombok.Data;

@Data
public class UserReturnDTO {
    private Long id;
    private String name;
    private String email;
    private List<TaskEntity> tasks;
}
