package com.italocosta.taskmanager.model.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String msg){
        super(msg);
    }
}
