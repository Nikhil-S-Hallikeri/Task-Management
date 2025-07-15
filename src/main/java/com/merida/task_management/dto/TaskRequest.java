package com.merida.task_management.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    private String description;
    @FutureOrPresent(message = "Due date must be in the present or future")
    private LocalDate dueDate;
}
