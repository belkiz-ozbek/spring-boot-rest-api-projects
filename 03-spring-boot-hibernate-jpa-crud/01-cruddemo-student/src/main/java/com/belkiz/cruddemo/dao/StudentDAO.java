package com.belkiz.cruddemo.dao;

import com.belkiz.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateStudent(Student student);
    void delete(int id);
    int deleteAll();

}
