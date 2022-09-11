package com.genspark.assignment2.First.Controller;

import com.genspark.assignment2.First.Entities.Student;
import com.genspark.assignment2.First.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String homePage(){
        return "<HTML><H1>Welcome to the Student Database Access Homepage</H1></HTML>";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return this.studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        return this.studentService.deleteStudentById(id);
    }
}
