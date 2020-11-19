package com.example.springworkshop.controllers;


import com.example.springworkshop.StudentService.StudentService;
import com.example.springworkshop.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable("id") final Long id) throws Exception {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping
    public List<Student> findStudentByFirstName(@RequestParam(value = "firstName") String firstName,
                                                @RequestParam(value = "lastName") String lastName) {
        return studentService.findUserByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping(value = "/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping(value = "/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus remove(@PathVariable final Long id) {
        studentService.deleteStudentById(id);
        return HttpStatus.FORBIDDEN;
    }
}
