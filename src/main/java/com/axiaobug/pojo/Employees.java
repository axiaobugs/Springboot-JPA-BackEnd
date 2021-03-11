package com.axiaobug.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {
    public Employees(String last_name, String first_name, String email, String address, String mobile, String wechat, Integer departments_id, Date hire_date) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.wechat = wechat;
        this.departments_id = departments_id;
        this.hire_date = hire_date;
    }

    public Employees(Integer employees_id, String last_name, String first_name, String email, String address, String mobile, String wechat, Integer departments_id, Date hire_date) {
        this.employees_id = employees_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.wechat = wechat;
        this.departments_id = departments_id;
        this.hire_date = hire_date;
    }

    @Id
    @Column(name = "employees_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employees_id;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "wechat")
    private String wechat;

    @Column(name = "departments_id")
    private Integer departments_id;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hire_date;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="departments_id",insertable = false,updatable = false)
    @JsonIgnore
    private Departments department;

    @OneToMany(targetEntity = SaleOrder.class)
    @JoinColumn(name = "pick_id",referencedColumnName = "employees_id",insertable = false,updatable = false)
    private Set<SaleOrder> saleOrder = new HashSet<>();

    @Override
    public String toString() {
        return "Employees{" +
                "employees_id=" + employees_id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", wechat='" + wechat + '\'' +
                ", departments_id=" + departments_id +
                ", hire_date=" + hire_date +
                '}';
    }


}
