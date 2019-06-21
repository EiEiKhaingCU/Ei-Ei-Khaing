package com.trustcore.intern.dta;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trustcore.intern.model.BookRent;
import com.trustcore.intern.model.Category;
@Repository
@Transactional
public class CategoryInfoImp implements CategoryInfo {
	@Autowired
	private SessionFactory sessionFactory;
	public void saveCategory(Category cate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(cate);

	}


	public List<Category> getCategory() {
		// TODO Auto-generated method stub
	 	return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		Category category=(Category)((org.hibernate.Session) session).get(Category.class,id);
		((org.hibernate.Session) session).delete(category);
		((org.hibernate.Session) session).flush();
	}

	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(c);

		
	}

	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Category category=(Category)sessionFactory.getCurrentSession().createCriteria(Category.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return category;

}

}
