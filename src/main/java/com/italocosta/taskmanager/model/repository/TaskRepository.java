package com.italocosta.taskmanager.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italocosta.taskmanager.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
