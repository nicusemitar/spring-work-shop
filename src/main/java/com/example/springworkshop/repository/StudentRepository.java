package com.example.springworkshop.repository;

import com.example.springworkshop.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findUserByFirstNameAndLastName(String firstName, String lastName);

}