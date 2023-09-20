package com.example.demostudent.service;

import com.example.demostudent.model.StudentModel;
import com.example.demostudent.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public void saveStudent(StudentModel model){
        studentRepository.save(model);
    }

}
