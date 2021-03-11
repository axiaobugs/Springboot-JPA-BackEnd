package com.axiaobug.dao;

import com.axiaobug.pojo.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface DepartmentDao extends JpaRepository<Departments,Integer>, JpaSpecificationExecutor<Departments> {
}
