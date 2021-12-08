package com.imi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imi.app.model.Student;
import com.imi.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService stuService;

	@GetMapping()
	public ResponseEntity<Object> getStudents() {
		List<Student> students = stuService.getStudents();
		return new ResponseEntity<Object>(students, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
		
		Student stu = stuService.saveStudent(student);
		return new ResponseEntity<Object>(stu, HttpStatus.CREATED);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Object> getStudentById(@PathVariable("studentId") long studentId) {
		Student student = stuService.getStudentById(studentId);
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}



	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
		student = stuService.updateStudent(student);
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}


	@CrossOrigin
	@DeleteMapping("/{studentId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") long studentId) {
		stuService.deleteStudent(studentId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
