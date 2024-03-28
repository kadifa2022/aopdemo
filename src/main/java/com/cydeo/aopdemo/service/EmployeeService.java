package com.cydeo.aopdemo.service;

import com.cydeo.aopdemo.entity.Employee;
import com.cydeo.aopdemo.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
       // System.out.println(" ");
        return  employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) throws Exception {
        if(employee.getName().length()> 5) // no more than 5 letter
            throw new Exception("Sorry please reduce your name");
       // System.out.println(" ");
        return employeeRepository.save(employee);
    }
}
