package com.trustcore.intern.dta;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trustcore.intern.model.Category;
import com.trustcore.intern.model.Student;

@Repository
@Transactional
public class StudentInfoImp implements StudentInfo {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}

	public Serializable saveStudent(Student student) {
		return sessionFactory.getCurrentSession().save(student);
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session=(Session) sessionFactory.getCurrentSession();
		Student student=(Student)((org.hibernate.Session) session).load(Student.class,id);
		((org.hibernate.Session) session).delete(student);
		((org.hibernate.Session) session).flush();
	}

	
}
