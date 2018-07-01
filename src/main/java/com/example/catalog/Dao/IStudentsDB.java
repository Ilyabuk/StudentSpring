package com.example.catalog.Dao;

import com.example.catalog.Entity.Student;

import java.util.Collection;

/**
 * Created by bukreyev on 7/1/2018.
 */
public interface IStudentsDB {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void putStudent(Student student);
}
