package com.codegym.th_module4.service.Class;

import com.codegym.th_module4.model.Classroom;
import com.codegym.th_module4.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService implements IClassService {
    @Autowired
    IClassRepository classRepository;
    @Override
    public Iterable<Classroom> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom city) {
        return classRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
