package com.codegym.c0824g1_spring_boot.service;

import com.codegym.c0824g1_spring_boot.model.Student;
import org.springframework.data.domain.Page;

public interface IStudentService extends IService<Student> {

    Page<Student> findByName(String name, Integer page);

}
