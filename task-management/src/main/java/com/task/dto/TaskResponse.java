package com.task.dto;


import com.task.entity.TaskPriority;
import com.task.entity.TaskStatus;

import java.time.LocalDate;



public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate dueDate,
        Long userId,
        String userName
) {}
