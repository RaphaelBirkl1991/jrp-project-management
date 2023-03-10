package com.jrp.pma.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter @Setter
@Entity @NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name="project_employee",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;




    public Employee(String firstName, String lastName, String email, List<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projects = projects;
    }


}
