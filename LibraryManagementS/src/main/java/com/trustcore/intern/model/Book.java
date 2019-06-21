package com.trustcore.intern.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.SimpleExpression;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;	
	private String name;
	private String author;
	private String isbn;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book(int id, String name, String author, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.isbn = isbn;
	}

	public Book() {
		super();
	}
	@ManyToOne
	private Category category=new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
