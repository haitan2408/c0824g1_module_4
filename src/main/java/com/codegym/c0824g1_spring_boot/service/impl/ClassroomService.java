package com.codegym.c0824g1_spring_boot.service.impl;

import com.codegym.c0824g1_spring_boot.model.Classroom;
import com.codegym.c0824g1_spring_boot.repository.ClassroomRepository;
import com.codegym.c0824g1_spring_boot.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public void save(Classroom s) {

    }

    @Override
    public void update(int id, Classroom s) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Classroom findById(int id) {
        return null;
    }

    @Override
    public List<Classroom> findByName(String name) {
        return List.of();
    }
}
