package com.task_management.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity create(TaskEntity data) {
        return taskRepository.save(data);
    }
}
