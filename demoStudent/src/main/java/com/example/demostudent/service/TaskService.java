package com.example.demostudent.service;

import com.example.demostudent.model.TaskModel;
import com.example.demostudent.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    public void saveTask(TaskModel taskModel) {
        taskRepository.save(taskModel);
    }


    public List<TaskModel> getTaskList() {
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }


    public List<TaskModel> findByColor(String name) {
        List<TaskModel> color = taskRepository.findByColor(name);
        log.info("color {}", color);
        return color;
    }


    public void updateTaskDescription(Long id, String description) {
        taskRepository.updateDescriptionById(id, description);
    }

}
