package com.example.catalog.Controller;

import com.example.catalog.Entity.Student;
import com.example.catalog.Exception.StudentException;
import com.example.catalog.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentsService studentsService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) throws StudentException {
        return studentsService.getStudentById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id) throws StudentException {
        studentsService.deleteStudentById(id);
        return new ResponseEntity<>("Success! ", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudentById(@RequestBody Student student) {
        studentsService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addStudent(@RequestBody Student student) throws StudentException {
        studentsService.putStudent(student);
    }
}
