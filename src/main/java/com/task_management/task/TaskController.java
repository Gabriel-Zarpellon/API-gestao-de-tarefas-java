package com.task_management.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public TaskEntity create(@RequestBody TaskEntity data) {
        TaskEntity response = taskService.create(data);

        return response;
    }
}
