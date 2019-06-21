package com.trustcore.intern.dta;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.stereotype.Repository;

import com.trustcore.intern.model.BookRent;
@Repository
@Transactional

public class BookRentInfoImp implements BookRentInfo{
	@Autowired
	private SessionFactory sessionFactory;
	public void saveBookRent(BookRent br) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(br);

	}

	public List<BookRent> getBookRent() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(BookRent.class).list();
	}

	public void deleteBookRent(int id) {
		// TODO Auto-generated method stub
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		BookRent bookrent=(BookRent)((org.hibernate.Session) session).get(BookRent.class,id);
		((org.hibernate.Session) session).delete(bookrent);
		((org.hibernate.Session) session).flush();
		
	}

}
