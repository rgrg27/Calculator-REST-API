package com.springboot.h2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class Oprator {

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the primary key values.
	@Id
	@GeneratedValue
	private int id;
	private char name;
	private int count;

	// Default constructor.
	public Oprator() {	}

	// Parameterized constructor.
	public Oprator(int id, char name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	// Getters.
	public int getId() {
		return id;
	}
	public char getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	//setters
	public void setId(int id){
		this.id = id;
	}
	public void setName(char name){
		this.name = name;
	}
	public void setCount(int count){
		this.count = count;
	}
}
