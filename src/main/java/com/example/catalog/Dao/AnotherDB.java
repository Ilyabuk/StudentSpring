package com.example.catalog.Dao;

import com.example.catalog.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("AnotherDB")
public class AnotherDB implements IStudentsDB {
    Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public Collection<Student> getAllStudents() {
        studentMap.put(1, new Student(1, "Jonny", "Mama"));
        return studentMap.values();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void putStudent(Student student) {

    }
}
