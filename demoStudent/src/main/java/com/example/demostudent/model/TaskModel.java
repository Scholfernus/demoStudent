package com.example.demostudent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date deadline;
    private String description;
    private String color;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date creationDate;
    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;

}
