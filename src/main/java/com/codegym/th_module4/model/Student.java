package com.codegym.th_module4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Vui lòng nhập giá trị")
    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    private LocalDate birthday;
    @NotEmpty(message = "Vui lòng nhập giá trị")
    @Column(columnDefinition = "VARCHAR(255)")
    private String address;
    @NotEmpty(message = "Vui lòng nhập giá trị")
    @Column(columnDefinition = "VARCHAR(255)")
    private String phoneNumber;
    @NotEmpty(message = "Vui lòng nhập giá trị")
    @Column(columnDefinition = "VARCHAR(255)")
    private String email;

    @ManyToOne
    private Classroom classroom;
}
