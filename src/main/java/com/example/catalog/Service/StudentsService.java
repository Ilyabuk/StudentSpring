package com.example.catalog.Service;

import com.example.catalog.Dao.IStudentsDB;
import com.example.catalog.Entity.Student;
import com.example.catalog.Exception.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentsService {
    @Qualifier("AnotherDB")
    @Autowired
    private IStudentsDB studentsDB;

    public Collection<Student> getAllStudents() {
        return studentsDB.getAllStudents();
    }

    public Student getStudentById(int id) throws StudentException {
        Student student = studentsDB.getStudentById(id);

        if (student != null) {
            return student;
        } else {
            throw new StudentException("Student not exist!");
        }
    }

    public void deleteStudentById(int id) throws StudentException {
        if (studentsDB.getStudentById(id) == null) {
            throw new StudentException("User you're trying to delete doesn't exist!");
        }
        studentsDB.deleteStudentById(id);
    }

    public void updateStudent(Student student) {
        studentsDB.updateStudent(student);
    }

    public void putStudent(Student student) throws StudentException {
            studentsDB.putStudent(student);
    }
}
