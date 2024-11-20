package com.example.demo_spring_data_jpa_c07.aop;


import com.example.demo_spring_data_jpa_c07.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;
//    @After("execution(* com.example.demo_spring_data_jpa_c07.controller.StudentController.*(..))")
//    public void countAccessSearchController(){
//        count ++;
//        System.out.println("------------" + count+ "----------------------------------");;
//    }

    @AfterThrowing("execution(* com.example.demo_spring_data_jpa_c07.controller.StudentController.save(..))")
    public void loggerAdminException(JoinPoint joinPoint){
       Object[] args = joinPoint.getArgs();
        StudentDto studentDto = (StudentDto) args[0];
        System.out.println("tên : " + studentDto.getName());
        System.out.println("------------trùng tên Admin----------------------------------");;
    }

//    @Around("execution(* com.example.demo_spring_data_jpa_c07.controller.StudentController.search(..))")
//    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("-------code chạy trước");
//        Object object = joinPoint.proceed();
//        System.out.println("-------code chạy sau");
//        return object;
//    }
}
