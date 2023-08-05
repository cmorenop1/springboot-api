package com.logiclab.logiclab.service;

import com.logiclab.logiclab.DAO.EmployeeDAO;
import com.logiclab.logiclab.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceConcrete implements EmployeeService {


    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeServiceConcrete(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int employeeId) {
        employeeDAO.deleteById(employeeId);
    }
}
