package com.italocosta.taskmanager.service;

import java.util.List;

import com.italocosta.taskmanager.model.dto.TaskRequestDTO;
import com.italocosta.taskmanager.model.entity.Task;
import com.italocosta.taskmanager.model.enums.TaskStatus;


public interface TaskService {

    public Task createTask(TaskRequestDTO task);
    public Task findTask(Long id);
    public List<Task> findAll();
    public Task updateTask(Long id, TaskRequestDTO task);
    public Task updateStatus(Long id, TaskStatus newStatus);
    public void removeTask(Long id);


}
