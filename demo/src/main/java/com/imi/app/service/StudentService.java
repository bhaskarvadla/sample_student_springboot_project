package com.imi.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imi.app.constants.ErrorConstants;
import com.imi.app.dao.StudentRepo;
import com.imi.app.exception.ResourceNotFoundException;
import com.imi.app.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public Student saveStudent(Student stu) {
		Student student = studentRepo.save(stu);
		return student;
	}

	public List<Student> getStudents() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	public Student getStudentById(long studentId) {

		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new ResourceNotFoundException(ErrorConstants.STUDENT_NOT_FOUND_CODE,
					ErrorConstants.STUDENT_NOT_FOUND_MESSAGE);
		}
	}

	public Student updateStudent(Student stu) {
		Optional<Student> student = studentRepo.findById(stu.getId());

		if (student.isPresent()) {
			studentRepo.save(stu);
		} else {
			throw new ResourceNotFoundException(ErrorConstants.STUDENT_NOT_FOUND_CODE,
					ErrorConstants.STUDENT_NOT_FOUND_MESSAGE);
		}

		return stu;
	}

	public void deleteStudent(long studentId) {
		Optional<Student> student = studentRepo.findById(studentId);

		if (student.isPresent()) {
			studentRepo.deleteById(studentId);
		} else {
			throw new ResourceNotFoundException(ErrorConstants.STUDENT_NOT_FOUND_CODE,
					ErrorConstants.STUDENT_NOT_FOUND_MESSAGE);
		}
	}

}
