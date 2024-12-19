package com.codegym.c0824g1.repository;

import com.codegym.c0824g1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();


    static {
        students.add(new Student(1, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 1));
        students.add(new Student(2, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 2));
        students.add(new Student(3, "Trương Tấn Hải", "hai.truong@codegym.vn", 8.0f, LocalDate.now(), 3));
    }

    public List<Student> findAll() {
        List<Student> students = BaseRepository.entityManager.createQuery("from students", Student.class).getResultList();
        return students;
    }

    public void save(Student s) {
//        Các tác vụ liên quan đến thay đổi dữ liệu thì cần đặt nó trong 1 transaction
        EntityTransaction transaction  = BaseRepository.entityManager.getTransaction();
        transaction.begin();
       BaseRepository.entityManager.persist(s);
       transaction.commit();
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
