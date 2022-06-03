package com.genspark.assignment2.First.Services;

import com.genspark.assignment2.First.Entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    String deleteStudentById(int id);
}
