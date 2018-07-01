package com.example.catalog.Dao;

import com.example.catalog.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("ManualData")
public class StudentsDB implements IStudentsDB {
    private static int counter = 0;
    private static Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(++counter, new Student(1, "Vanya", "Math"));
        studentMap.put(++counter, new Student(2, "Sanek", "Math"));
        studentMap.put(++counter, new Student(3, "Mishanya", "Litra"));
        studentMap.put(++counter, new Student(4, "Petrovich", "Litra"));
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    @Override
    public Student getStudentById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        studentMap.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = new Student();
        s.setId(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        studentMap.put(student.getId(), s);
    }

    @Override
    public void putStudent(Student student) {
        Student s = new Student();
        s.setId(++counter);
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        studentMap.put(s.getId(), s);
    }
}
