package com.springboot.h2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class MathExpression {

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the primary key values.
	@Id
	@GeneratedValue
	private long id;
	private String exp;
	

	// Default constructor.
	public MathExpression() {	}

	// Parameterized constructor.
	public MathExpression(String exp) {
		this.exp = exp;
		
	}

	// Getters.
	public long getId() {
		return id;
	}
	public String getexp() {
		return exp;
	}
	
	//Setters
	public void setExp(String exp) {
		this.exp = exp;
	}
}
