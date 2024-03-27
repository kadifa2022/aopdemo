package com.cydeo.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
   // @AfterReturning(value = "execution(* om.cydeo.aopdemo.service.EmployeeService.addEmployee(..))")


}
