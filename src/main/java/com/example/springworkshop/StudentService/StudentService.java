package com.example.springworkshop.StudentService;


import com.example.springworkshop.repository.StudentRepository;
import com.example.springworkshop.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(final Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent (Student student){
//        studentRepository.findById(student.getId());
       return studentRepository.save(student);
    }

    public List<Student> findUserByFirstNameAndLastName(String firstName, String lastName){
        return studentRepository.findUserByFirstNameAndLastName(firstName,lastName);
    }
}
