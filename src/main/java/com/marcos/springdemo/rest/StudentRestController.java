package com.marcos.springdemo.rest;

import com.marcos.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    private List<Student> theStudents;

    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Marcos", "Lira"));
        theStudents.add(new Student("Allen", "Something"));
        theStudents.add(new Student("Mary", "Smith"));
    }


    @GetMapping("/students")
    public List<Student> showStudents()
    {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if( (studentId >= theStudents.size()) || (studentId < 0) )
        {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}