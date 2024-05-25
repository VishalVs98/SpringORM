package com.springorm.springorm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


import com.springorm.springorm.entities.Student;

public class StudentDao {

/*	private HibernateTemplate hibernateTemplate;
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
public StudentDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}*/
private SessionFactory sessionFactory;

	public StudentDao() {
	}

	public StudentDao(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Integer insert(Student students){
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        session.saveOrUpdate(students);
	        session.getTransaction().commit();
	    }
	    return 1;
	}
	public Student getStudent(int id) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        // Retrieve the student with the specified ID
	        Student student = session.get(Student.class, id);

	        session.getTransaction().commit();
	        return student;
	    }
	}

	}

