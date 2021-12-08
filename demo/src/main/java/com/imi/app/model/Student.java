package com.imi.app.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
	@Column(name = "class")
	private int stdClass;
	@Column(name = "email")
	private String email;

	public int getStdClass() {
		return stdClass;
	}

	public void setStdClass(int stdClass) {
		this.stdClass = stdClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(long id, String firstName, String secondName, int stdClass, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.stdClass = stdClass;
		this.email = email;
	}

	public Student() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + " , email=" + email + ", secondName=" + secondName + ", stdClass="
				+ stdClass + "]";
	}

}