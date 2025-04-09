package com.italocosta.taskmanager.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.italocosta.taskmanager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "task_body")
    private String description;
    
    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "crated_at")
    LocalDateTime createdAt;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "updated_at")
    LocalDateTime updatedAt;


}
