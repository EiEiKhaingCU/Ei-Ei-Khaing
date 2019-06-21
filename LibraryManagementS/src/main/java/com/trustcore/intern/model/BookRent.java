package com.trustcore.intern.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookRent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int id;
	private int qty;
	private Date  rentdate;
	@ManyToOne
	@JoinColumn(name="bookId")
	private Book book=new Book();
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student=new Student();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getRentdate() {
		return rentdate;
	}



	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}

	public BookRent(int id, int qty, Date rentdate) {
		super();
		this.id = id;
		this.qty = qty;
		this.rentdate = rentdate;
	}

	public BookRent() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
