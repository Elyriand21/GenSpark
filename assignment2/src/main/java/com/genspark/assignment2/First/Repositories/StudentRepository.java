package com.genspark.assignment2.First.Repositories;

import com.genspark.assignment2.First.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
