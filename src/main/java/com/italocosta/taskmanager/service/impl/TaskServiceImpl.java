package com.italocosta.taskmanager.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italocosta.taskmanager.model.dto.TaskRequestDTO;
import com.italocosta.taskmanager.model.entity.Task;
import com.italocosta.taskmanager.model.exceptions.TaskNotFoundException;
import com.italocosta.taskmanager.model.repository.TaskRepository;
import com.italocosta.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Task createTask(TaskRequestDTO task) {

        System.out.println("service: " + task);
        Task newTask = new Task(
            null, 
            task.title(), 
            task.description(), 
            task.status(), 
            LocalDateTime.now(), 
            null);

        return repository.save(newTask); 
    }

    @Override
    public Task findTask(Long id) {

        Task task = findById(id);
        return task;
    }

    @Override
    public List<Task> findAll() {

        return repository.findAll();
    }

    @Override
    public Task updateTask(Long id, TaskRequestDTO task) {

        Task updateTask = findById(id);
        
        updateTask.setTitle(task.title());
        updateTask.setDescription(task.description());
        updateTask.setStatus(task.status());
        updateTask.setUpdatedAt(LocalDateTime.now());
        
        return repository.save(updateTask);
    }

    @Override
    public void removeTask(Long id) {

        Task removeTask = findById(id);
        repository.delete(removeTask);
    }

    private Task findById(Long id){

        Task task = repository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        return task;
    }
}
