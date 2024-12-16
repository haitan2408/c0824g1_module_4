package com.codegym.c0824g1.repository;

import com.codegym.c0824g1.model.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 1));
        students.add(new Student(2, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 1));
        students.add(new Student(3, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 1));
    }

    public List<Student> findAll() {

        return students;
    }

    public void save(Student s) {
        s.setId(students.get(students.size()-1).getId() + 1);
        students.add(s);
    }

    public void remove(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                break;
            }
        }
    }
}
