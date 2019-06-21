package com.trustcore.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	@Column(name="Name",columnDefinition="NVARCHAR(255)")
	private String name;
	@Column(name="RoleNo",columnDefinition="NVARCHAR(255)")
	private String rno;
	@Column(name="NRC",columnDefinition="NVARCHAR(255)")
	private String nrc;
	@Column(name="Grade",columnDefinition="NVARCHAR(255)")
	private String grade;
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
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student(int id, String name, String rno, String nrc, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.rno = rno;
		this.nrc = nrc;
		this.grade = grade;
	}
	public Student() {
		super();
	}
	

	
}
