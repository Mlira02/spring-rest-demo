package com.marcos.springdemo.rest;

import com.marcos.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{

    @GetMapping("/students")
    public List<Student> showStudents()
    {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Marcos", "Lira"));
        theStudents.add(new Student("Allen", "Something"));
        theStudents.add(new Student("Mary", "Smith"));

        return theStudents;
    }
}
