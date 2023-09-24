package com.example.demostudent.service;

import com.example.demostudent.model.TaskModel;
import com.example.demostudent.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    public List<TaskModel> getTaskList(){
        return taskRepository.findAll();
    }

    public void saveTask(TaskModel task) {
        taskRepository.save(task);
    }
    public void addTask(TaskModel taskModel) {
       taskRepository.save(taskModel);
    }
}
