package com.imi.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imi.app.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
