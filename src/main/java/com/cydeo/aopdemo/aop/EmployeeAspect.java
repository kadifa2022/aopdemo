package com.cydeo.aopdemo.aop;

import com.cydeo.aopdemo.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class EmployeeAspect {




    // before executing any method of employee controller with any number of argument please do  this ..
    @Before(value = "execution (* com.cydeo.aopdemo.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){ // fetch all employees
        System.out.println("Request to" + joinPoint.getSignature() + "started at " + new Date());

    }
    @After(value = "execution (* com.cydeo.aopdemo.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){ // fetch all employees
        System.out.println("Request to" + joinPoint.getSignature() + "ended at " + new Date());

    }
    @Before(value = "execution (* com.cydeo.aopdemo.service.EmployeeService.*(..))")
    public void beforeAdviceForService(JoinPoint joinPoint){ // fetch all employees
        System.out.println("Request to service layer" + joinPoint.getSignature() + "started at " + new Date());

    }
    @After(value = "execution (* com.cydeo.aopdemo.service.EmployeeService.*(..))")
    public void afterAdviceForService(JoinPoint joinPoint){ // fetch all employees
        System.out.println("Request to service layer" + joinPoint.getSignature() + "ended at " + new Date());

    }

    @AfterReturning(value = "execution (* com.cydeo.aopdemo.service.EmployeeService.addEmployee(..))", returning = "employee")
    public void afterReturningAdviceForAddEmployeeService(JoinPoint joinPoint, Employee employee ){

        System.out.println("Business logic to save an employee run successfully and employee is saved with id " + employee.getId());

    }
    @AfterThrowing(value = "execution (* com.cydeo.aopdemo.service.EmployeeService.addEmployee(..))", throwing = "exception")
    public void afterThrowingAdviceForAddEmployeeService(JoinPoint joinPoint, Exception exception ){

        System.out.println("Business logic to save an employee threw an exception " + exception.getMessage());

    }


}
