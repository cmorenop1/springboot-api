package com.logiclab.logiclab.DAO;

import com.logiclab.logiclab.entity.Employee;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void deleteById(int employeeId);
}








