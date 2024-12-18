package com.task_management.task;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String description;
}
