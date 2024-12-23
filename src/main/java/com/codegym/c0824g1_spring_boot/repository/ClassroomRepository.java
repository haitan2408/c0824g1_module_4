package com.codegym.c0824g1_spring_boot.repository;

import com.codegym.c0824g1_spring_boot.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
