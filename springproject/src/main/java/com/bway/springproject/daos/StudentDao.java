package com.bway.springproject.daos;

import java.util.List;

import com.bway.springproject.models.Student;

public interface StudentDao {
	 void addStudent(Student s); 
	 
	 void deleteStudent(int id);
	 
	 void upgradeStudent(Student e);
	 
	 Student getById(int id);
	 
	 List<Student> getAllStudent();

}
