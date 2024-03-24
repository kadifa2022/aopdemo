package com.cydeo.aopdemo.controller;

import com.cydeo.aopdemo.entity.Employee;
import com.cydeo.aopdemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllEmployee(){
       // System.out.println("Request to fetch all employees started at " + new Date());
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        System.out.println("");
        return  new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
    }




}
