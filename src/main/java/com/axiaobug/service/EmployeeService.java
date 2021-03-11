package com.axiaobug.service;

import com.axiaobug.dao.EmployeeDao;
import com.axiaobug.pojo.Departments;
import com.axiaobug.pojo.Employees;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    public boolean addEmployee(String last_name,
                                 String first_name,
                                 String email,
                                 String address,
                                 String mobile,
                                 String wechat,
                                 Integer departments_id,
                                 Date hire_date){
        Employees employee = new Employees(last_name,
                first_name,
                email,
                address,
                mobile,
                wechat,
                departments_id,
                hire_date);

        try{
            employeeDao.save(employee);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean addEmployee(Employees employee){

        try{
            employeeDao.save(employee);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Employees> getAllDepartment(){
        try{
            List<Employees> employees = employeeDao.findAll();
            return employees;
        }catch (Exception e){
            return null;
        }
    }

    public Employees getEmployeeById(Integer id){
        try{
            Employees employees = employeeDao.getOne(id);
            return employees;
        }catch (Exception e){
            return null;
        }
    }

    public boolean deleteEmployee(Integer id){
        try{
            employeeDao.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}