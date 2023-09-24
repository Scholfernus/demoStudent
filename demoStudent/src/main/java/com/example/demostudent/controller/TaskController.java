package com.example.demostudent.controller;

import com.example.demostudent.model.StudentModel;
import com.example.demostudent.model.TaskModel;
import com.example.demostudent.service.StudentService;
import com.example.demostudent.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TaskController {
    private final TaskService taskService;
    private final StudentService studentService;
    @GetMapping("/tasks")
    public String getTaskList(){
        return "tasks/tasks";
    }
    @GetMapping("/addTask")
    public String getAddTask(Model model){
        List<StudentModel> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "tasks/addTask";
    }
    @PostMapping("/addTask")
    public RedirectView postAddTask(@RequestParam("studentId") Long studentId,
                                    @RequestParam("deadline") @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline,
                                    @RequestParam("description") String description) {

        // Pobierz odpowiedniego studenta na podstawie studentId
        StudentModel student = studentService.getStudentById(studentId);
        TaskModel task = new TaskModel();
        task.setStudent(student);
        task.setDeadline(deadline);
        task.setDescription(description);
        task.setCreationDate(new Date());

        // Zapisz zadanie w serwisie
        taskService.saveTask(task);

        return new RedirectView("/tasks");
    }


}
