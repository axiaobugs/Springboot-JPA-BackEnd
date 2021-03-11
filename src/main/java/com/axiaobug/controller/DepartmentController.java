package com.axiaobug.controller;


import com.axiaobug.pojo.Departments;
import com.axiaobug.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//TODO: Add a feature display num of same department of employee
//GET:  go to the page
//POST: ADD
//PATCH: UPDATE
//DELETE: delete


@Controller
public class DepartmentController {
    @Resource
    public  DepartmentService departmentService;

    //Go to the department.html
    @GetMapping("/department")
    public String department(Model model){
        List<Departments> allDepartment = departmentService.getAllDepartment();
        model.addAttribute("list_department",allDepartment);
        return "department/department";
    }

    //get the department class in the swagger ui
    @PostMapping("/department")
    public Departments department(){
        return new Departments();
    }

    //Go to the addDepartment page
    @GetMapping(value = "/department/edit")
    public String showAddDepartment(){
        return "department/addDepartment";
    }

    //add a department
    @PostMapping(value = "/department/edit")
    public String addDepartment(@RequestParam("department_name") String department_name,
                             @RequestParam(name = "manager_id",defaultValue = "0") String manager_id,
                             Model model){
        if(manager_id.isEmpty()){
            model.addAttribute("msg","manager_id can not empty or use 0");
            return "redirect:/department";
        }
        boolean bool = departmentService.addDepartment(department_name, Integer.parseInt(manager_id));
        if(bool){
            return "redirect:/department";
        }else {
            model.addAttribute("msg","add failure");
            return "redirect:/department";
        }

    }


    //Goto  update department page
    @GetMapping ("/department/edit/{department_id}")
    public String toUpdateDepartment(@PathVariable("department_id") Integer id,
                                   Model model){
        Departments departmentById = departmentService.getDepartmentById(id);
        model.addAttribute("department",departmentById);
        return "department/update";
    }

    //Update department
    @PutMapping ("/department/edit")
    public String UpdateDepartment(@RequestParam("department_name") String department_name,
                                   @RequestParam(name = "manager_id",defaultValue = "0") String manager_id,
                                   @RequestParam("department_id") String department_id){
        int man_id = Integer.parseInt(manager_id);
        int dep_id = Integer.parseInt(department_id);
        Departments dep = new Departments(dep_id, department_name, man_id);
        departmentService.addDepartment(dep);
        return "redirect:/department";
    }

    //Delete department
    @DeleteMapping ("/department/edit/{department_id}")
    public String deleteDepartment(@PathVariable("department_id") Integer id){
        departmentService.deleteDepartment(id);
        return "redirect:/department";
    }

}
