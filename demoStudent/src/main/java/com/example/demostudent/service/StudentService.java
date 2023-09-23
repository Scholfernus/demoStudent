package com.example.demostudent.service;

import com.example.demostudent.model.StudentModel;
import com.example.demostudent.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public void saveStudent(StudentModel model){
        studentRepository.save(model);
    }


    public List<StudentModel> getStudentList() {
        return studentRepository.findAll();
    }

    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void saveEditStudent(StudentModel student, Long id){
        student.setId(id);
        studentRepository.save(student);
    }
}
