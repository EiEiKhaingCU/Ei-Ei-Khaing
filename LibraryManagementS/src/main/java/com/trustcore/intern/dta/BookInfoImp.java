package com.trustcore.intern.dta;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trustcore.intern.dto.BookDTO;
import com.trustcore.intern.model.Book;
import com.trustcore.intern.model.Category;
@Repository
@Transactional
public class BookInfoImp implements BookInfo {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(book);
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		Book book=(Book)((org.hibernate.Session) session).get(Book.class,id);
		((org.hibernate.Session) session).delete(book);
		((org.hibernate.Session) session).flush();
	}

	public BookDTO getBook(int id) {
		// TODO Auto-generated method stub
		Book c=(Book)sessionFactory.getCurrentSession().createCriteria(Book.class)
				.createAlias("book", "c",JoinType.LEFT_OUTER_JOIN);
		((Criteria) c).add(Restrictions.eq("id", id));
		((Criteria) c).setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("author"),"author")
				.add(Projections.property("isbn"),"isbn")
				.add(Projections.property("c.id"),"categoryId")
				);
		((Criteria) c).setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return (BookDTO)((Criteria) c).uniqueResult();
	}

	public void updateBook(Book bk) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(bk);

		
	}

}
