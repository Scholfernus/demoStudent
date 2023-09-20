package com.example.demostudent.controller;

import com.example.demostudent.model.StudentModel;
import com.example.demostudent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
@RequiredArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/students")
    public String addPersonList() {
        return "persons/personList";
    }
    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }
    @GetMapping("/editStudent")
    public String getEditStudent(){
        return "persons/editPerson";
    }
    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student){
    return new RedirectView("/students");
    }
}
