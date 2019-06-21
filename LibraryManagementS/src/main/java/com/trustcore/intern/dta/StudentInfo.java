package com.trustcore.intern.dta;

import java.io.Serializable;
import java.util.List;

import com.trustcore.intern.model.Student;


public interface StudentInfo{
	public Serializable saveStudent(Student student);
	public List<Student> getStudent();
	public void deleteStudent(int id);
	}
