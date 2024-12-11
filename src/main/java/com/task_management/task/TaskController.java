package com.task_management.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_management.task.dtos.TaskCreateDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public TaskEntity create(@RequestBody TaskEntity data) {
        TaskEntity response = taskService.create(data);

        return response;
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> readOne(@PathVariable UUID id) {
        Optional<TaskEntity> response = taskService.readOne(id);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        taskService.delete(id);

        return ResponseEntity.status(204).body(null);
    }
}
