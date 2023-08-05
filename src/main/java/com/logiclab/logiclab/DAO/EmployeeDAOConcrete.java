package com.logiclab.logiclab.DAO;

import com.logiclab.logiclab.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * The @Repository annotation is a marker for any class that fulfills the role
 * of repository or Data Access Object (DAO) in the context of Domain-Driven Design.
 *
 * This annotation provides several benefits:
 *
 * 1. Auto-detection: Spring's component scanning automatically detects @Repository
 *    classes and creates bean definitions for them. This greatly simplifies
 *    configuration and reduces boilerplate code.
 *
 * 2. Exception Translation: It translates technology-specific exceptions
 *    (such as SQL exceptions) into Spring's consistent, unchecked DataAccessExceptions
 *    for cleaner error handling.
 *
 * 3. Clear Role: It makes clear the role of the class in the application context
 *    improving maintainability and understanding of the code.
 */


/**
 * When a class that acts as a DAO (Data Access Object) is not annotated with @Repository:
 *
 * 1. Spring's component scanner will not detect and register this class as a bean
 *    in the Spring Application Context. As a result, the class will not be
 *    instantiated and its methods cannot be automatically wired into other
 *    beans that require it.
 *
 * 2. The class will not be able to take advantage of Spring's DataAccessException
 *    hierarchy. Spring's @Repository annotation provides a mechanism to catch
 *    platform-specific exceptions and re-throw them as one of Spring's unified
 *    unchecked exceptions. This results in a technology-agnostic way to handle
 *    exceptions, improving the code's maintainability and robustness.
 *
 * If a class is not annotated with @Repository (or one of the other stereotype
 * annotations), it will be necessary to manually configure and manage this
 * class, which can lead to more boilerplate code and less consistent error
 * handling.
 */


/**
 * In Spring Framework, a "bean" refers to an object that is managed by the Spring container.
 * This terminology is derived from JavaBeans, which is a component architecture in Java.
 */

public class EmployeeDAOConcrete implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOConcrete(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("FROM Employee", Employee.class);

        List<Employee> employees = employeeQuery.getResultList();

        // Debugging the content of employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove((employee));
    }
}
