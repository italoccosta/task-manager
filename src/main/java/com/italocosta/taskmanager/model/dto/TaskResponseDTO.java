package com.italocosta.taskmanager.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.italocosta.taskmanager.model.enums.TaskStatus;

public record TaskResponseDTO(

    Long id,
    String title,
    String description,
    TaskStatus status,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime createdAt

) {

}
