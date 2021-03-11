package com.axiaobug.controller;

import com.axiaobug.pojo.Employees;
import com.axiaobug.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmpoyeeController {

    @Resource
    public EmployeeService employeeService;

    //Goto the employee page
    @GetMapping("/employees")
    public String getEmpolyee(Model model) {
        List<Employees> allEmp = employeeService.getAllDepartment();
        model.addAttribute("list_emp", allEmp);
        return "employee/employee";
    }

    //get the employee class in the swagger ui
    @PostMapping("/employees")
    public Employees employee(){
        return new Employees();
    }

    //Goto the add page
    @GetMapping("/employees/edit")
    public String toAddEmployee() {

        return "employee/add";
    }

    //Add a employee
    @PostMapping(value = "/employees/edit")
    public String addEmployee(@RequestParam("last_name") String last_name,
                                @RequestParam("first_name") String first_name,
                                @RequestParam("email") String email,
                                @RequestParam("address") String address,
                                @RequestParam("mobile") String mobile,
                                @RequestParam("wechat") String wechat,
                                @RequestParam(value = "departments_id", defaultValue = "999") String departments_id,
                                @RequestParam("hire_date") String hire_date,
                                Model model) throws ParseException {

        int id = Integer.parseInt(departments_id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(hire_date);
        Boolean bool = employeeService.addEmployee(last_name, first_name, email, address, mobile, wechat, id, d);
        if (!bool) {
            model.addAttribute("msg", "add failure");
            System.out.println("failure");
        }
        return "redirect:/employees";

    }

    //Goto  update employee page
    @GetMapping ("/employees/edit/{employee_id}")
    public String toUpdateEmployee(@PathVariable("employee_id") Integer id,
                                     Model model){
        Employees employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        return "employee/update";
    }

    //Update department
    @PutMapping("/employees/edit")
    public String UpdateEmployee(@RequestParam("employees_id")  String employees_id,
                                   @RequestParam("last_name") String last_name,
                                   @RequestParam("first_name") String first_name,
                                   @RequestParam("email") String email,
                                   @RequestParam("address") String address,
                                   @RequestParam("mobile") String mobile,
                                   @RequestParam("wechat") String wechat,
                                   @RequestParam(value = "departments_id", defaultValue = "999") String departments_id,
                                   @RequestParam("hire_date") String hire_date,
                                   Model model) throws ParseException {
        int emp_id = Integer.parseInt(employees_id);
        int dep_id = Integer.parseInt(departments_id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(hire_date);
        Employees employee = new Employees(emp_id, last_name, first_name, email, address, mobile, wechat, dep_id, d);
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @DeleteMapping ("/employees/edit/{employees_id}")
    public String deleteDepartment(@PathVariable("employees_id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
