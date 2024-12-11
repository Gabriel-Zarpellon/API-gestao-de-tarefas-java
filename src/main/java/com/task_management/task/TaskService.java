package com.task_management.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_management.exceptions.NotFoundException;

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

    public TaskEntity readOne(UUID id) throws NotFoundException{
        return taskRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    public void delete(UUID id) throws NotFoundException {
        taskRepository.findById(id).orElseThrow(()-> new NotFoundException());
        taskRepository.deleteById(id);
        return;
    }
}
