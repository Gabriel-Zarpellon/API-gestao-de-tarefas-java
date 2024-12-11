package com.task_management.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity create(TaskEntity data) {
        return taskRepository.save(data);
    }

    public List<TaskEntity> read(Optional<String> status) {
        if (!status.isEmpty()) {
            return taskRepository.findByStatus(status);
        }
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> readOne(UUID id) {
        return taskRepository.findById(id);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
        return;
    }
}
