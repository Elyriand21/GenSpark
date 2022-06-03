package com.genspark.assignment2.First.Services;

import com.genspark.assignment2.First.Entities.Student;
import com.genspark.assignment2.First.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return Streamable.of(studentRepository.findAll()).toList();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = this.studentRepository.findById(id);
        Student temp = null;

        if(student.isPresent()){
            temp = student.get();
        }
        else{
            throw new RuntimeException("Student by the ID of " + id + " cannot be found.");
        }
        return temp;
    }

    @Override
    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {

        return this.studentRepository.save(student);
    }

    @Override
    public String deleteStudentById(int id) {

        Optional<Student> student = this.studentRepository.findById(id);
        Student temp = null;

        if(student.isPresent()){
            temp = student.get();
        }
        else{
            throw new RuntimeException("Student by ID is not found!");
        }

        this.studentRepository.delete(temp);
        return "Student by the ID of " + id + " has been successfully deleted...";
    }
}
