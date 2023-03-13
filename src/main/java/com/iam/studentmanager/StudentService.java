package com.iam.studentmanager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        var existingStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Email [" + student.getEmail() + "] already exist");
        }
        return studentRepository.save(student);
    }

}
