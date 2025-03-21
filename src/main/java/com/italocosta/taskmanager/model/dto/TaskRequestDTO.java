package com.italocosta.taskmanager.model.dto;

import com.italocosta.taskmanager.model.enums.TaskStatus;

public record TaskRequestDTO (
 
    String title,
    String description,
    TaskStatus status
    
) {
}
