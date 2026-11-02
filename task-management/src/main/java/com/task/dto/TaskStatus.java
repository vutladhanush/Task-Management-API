package com.task.dto;



import jakarta.validation.constraints.NotNull;

public record TaskStatus(

        @NotNull(message = "Status is required")
        com.task.entity.TaskStatus status

) {}
