package com.alfred.employeemanagement.models;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name="Name", nullable = false)
    private String name;

    @Column(name="Surname", nullable = false)
    private String surname;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Department")
    private String department;


    public Employee(){

    }

    public Employee(String name, String surname, String email, String department) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
