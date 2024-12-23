package com.codegym.c0824g1_spring_boot.repository;

import com.codegym.c0824g1_spring_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//    HQL or SQl
//    @Query(value = "select * from students s where s.name_student like %:name%", nativeQuery = true)
    List<Student> findAllByNameContainingIgnoreCase(String name);

    Page<Student> findAllByNameContainingIgnoreCase(String name, Pageable page);

}
