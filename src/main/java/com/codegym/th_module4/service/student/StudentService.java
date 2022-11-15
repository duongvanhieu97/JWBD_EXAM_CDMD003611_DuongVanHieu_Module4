package com.codegym.th_module4.service.student;

import com.codegym.th_module4.model.Student;
import com.codegym.th_module4.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student city) {
        return studentRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }
}
