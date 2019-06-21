package com.trustcore.intern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	@Column(name="Name",columnDefinition="NVARCHAR(255)")
	private String name;
	@Column(name="Description",columnDefinition="NVARCHAR(255)")
	private String des;
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
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Category(int id, String name, String des) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
	}
	public Category() {
		super();
	}

	
}
