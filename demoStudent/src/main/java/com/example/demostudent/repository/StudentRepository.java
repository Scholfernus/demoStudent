package com.example.demostudent.repository;

import com.example.demostudent.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

//    List<StudentModel> findSortedNames();
//    List<StudentModel> findAllByOrderByLastNameAsc();
//
//
//    List<StudentModel> findSortedStudentsByLastName();
}
