package com.example.demostudent.controller;

import com.example.demostudent.model.StudentModel;
import com.example.demostudent.model.TaskModel;
import com.example.demostudent.service.StudentService;
import com.example.demostudent.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {


    private final StudentService studentService;
    private final TaskService taskService;


    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> list = taskService.getTaskList();
        model.addAttribute("taskModel", list);
        return "tasks/tasks";
    }


    @GetMapping("/addTask")
    public String getAddTask(Model model) {
        List<StudentModel> list = studentService.getStudentList();
        model.addAttribute("studentModel", list);
        return "tasks/addTask";
    }


    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        taskService.saveTask(task);
        return new RedirectView("/tasks");
    }

    @PostMapping("editDescription/{id}")
    public RedirectView patchDescription(@PathVariable("id") Long id,
                                         @RequestParam String description) {
        taskService.updateTaskDescription(id, description);
        return new RedirectView("/tasks");
    }

    @GetMapping("/byColor/{name}")
    public String getColor(@PathVariable String name) {
        taskService.findByColor(name);
        return "task/editTask";
    }

    @GetMapping("/editTask/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        List<StudentModel> list = studentService.getStudentList();
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("studentModel", list);
        model.addAttribute("taskModel", task);
        return "tasks/editTask";
    }
}


//    @GetMapping("/tasks")
//    public String getTaskList(){
//        return "tasks/tasks";
//    }


//    @PostMapping("/addTask")
//    public RedirectView postAddTask(@RequestParam("studentId") Long studentId,
//                                    @RequestParam("deadline") @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline,
//                                    @RequestParam("description") String description) {
//
//        // Pobierz odpowiedniego studenta na podstawie studentId
//        StudentModel student = studentService.getStudentById(studentId);
//        TaskModel task = new TaskModel();
//        task.setStudent(student);
//        task.setDeadline(deadline);
//        task.setDescription(description);
//        task.setCreationDate(new Date());
//
//        // Zapisz zadanie w serwisie
//        taskService.saveTask(task);
//
//        return new RedirectView("/tasks");
//    }