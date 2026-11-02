package com.task.dto;

import com.task.entity.TaskPriority;
import com.task.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskRequest(

        @NotBlank(message = "Task title is required")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Status is required")
        TaskStatus status,

        @NotNull(message = "Priority is required")
        TaskPriority priority,

        @NotNull(message = "Due date is required")
        LocalDate dueDate,

        @NotNull(message = "User ID is required")
        Long userId

) {}
