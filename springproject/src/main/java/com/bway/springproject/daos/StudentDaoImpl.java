package com.bway.springproject.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.models.Student;

@Repository

public class StudentDaoImpl implements StudentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addStudent(Student s) {
		Session sess = sessionFactory.getCurrentSession();
//		sess.save(s.getAddress()); 
		sess.save(s);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		Session sess = sessionFactory.getCurrentSession();
		Student s = (Student) sess.get(Student.class, id);
		sess.delete(s);
	}

	@Transactional
	@Override
	public void upgradeStudent(Student s) {
		Session sess= sessionFactory.getCurrentSession();
		sess.update(s);
	}
	
	@Transactional
	@Override
	public Student getById(int id) {
		Session sess= sessionFactory.getCurrentSession();
		Student emp=(Student)sess.get(Student.class, id);		
		return emp;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		Session sess= sessionFactory.getCurrentSession();
		Criteria crt= sess.createCriteria(Student.class);
		return crt.list();
	}

}
