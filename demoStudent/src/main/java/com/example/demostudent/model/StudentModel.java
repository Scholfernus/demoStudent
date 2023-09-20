package com.example.demostudent.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "git_hub")
    private String gitHub;

    @Column(name = "start")
    @Size(min = 3)
    private String start;
}
