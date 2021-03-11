package com.axiaobug;

import com.axiaobug.dao.DepartmentDao;
import com.axiaobug.pojo.Departments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpaApplicationTests {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void addDepartmentDao(){
        Departments department = new Departments("manager", 0);

        departmentDao.save(department);

    }

}
