package com.italocosta.taskmanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.italocosta.taskmanager.model.dto.TaskRequestDTO;
import com.italocosta.taskmanager.model.dto.TaskResponseDTO;
import com.italocosta.taskmanager.model.entity.Task;
import com.italocosta.taskmanager.model.enums.TaskStatus;
import com.italocosta.taskmanager.service.TaskService;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;


    @PostMapping
    ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO task) {

        Task newTask = service.createTask(task);

        TaskResponseDTO response = getResponseDTO(newTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);                
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponseDTO> findTask(@PathVariable Long id) {
       
        Task task = service.findTask(id);

        TaskResponseDTO response = getResponseDTO(task);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    ResponseEntity<List<TaskResponseDTO>> findAllTasks(){
        List<Task> list = service.findAll();

        return ResponseEntity.ok().body(list.stream()
        .map(lt -> getResponseDTO(lt))
        .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO task){
        Task updateTask = service.updateTask(id, task);

        TaskResponseDTO response = getResponseDTO(updateTask);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PutMapping("/status/{id}")
    ResponseEntity<TaskResponseDTO> updateTaskStatus(@PathVariable Long id,@RequestParam TaskStatus status) {
        Task update = service.updateStatus(id, status);
        TaskResponseDTO response = getResponseDTO(update);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.removeTask(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
    private TaskResponseDTO getResponseDTO(Task task) {
        return new TaskResponseDTO(
            task.getId(),
            task.getTitle(), 
            task.getDescription(),
            task.getStatus(),
            task.getCreatedAt());
    }
    
}
