package com.axiaobug.dao;

import com.axiaobug.pojo.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeDao extends JpaRepository<Employees,Integer>{
}
