package com.axiaobug.service;

import com.axiaobug.dao.DepartmentDao;
import com.axiaobug.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    public boolean addDepartment(String name,Integer manager_id){
        Departments department = new Departments(name, manager_id);
        try{
            departmentDao.save(department);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addDepartment(Departments department){
        try{
            departmentDao.save(department);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Departments> getAllDepartment(){
        try{
            List<Departments> departments = departmentDao.findAll();
            return departments;
        }catch (Exception e){
            return null;
        }
    }

    public Departments getDepartmentById(Integer id){
        try{
            Departments depOne = departmentDao.getOne(id);
            return depOne;
        }catch (Exception e){
            return null;
        }
    }

    public boolean deleteDepartment(Integer id){
        try{
            departmentDao.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
