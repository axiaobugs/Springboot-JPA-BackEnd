package com.axiaobug.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api
@Entity
@Table(name = "departments")
public class Departments {
    public Departments(String department_name, Integer manager_id) {
        this.department_name = department_name;
        this.manager_id = manager_id;
    }

    public Departments(Integer department_id, String department_name, Integer manager_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.manager_id = manager_id;
    }

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "manager_id")
    private Integer manager_id;

    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="departments_id")
    @JsonIgnore
    private Set<Employees> employees;


    @Override
    public String toString() {
        return "Departments{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }
}
