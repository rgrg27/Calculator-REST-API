package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.model.MathExpression;
import com.springboot.h2.repo.MathExpressionRepository;
import org.nfunk.jep.JEP;


@Service
public class MathExpressionService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	MathExpressionRepository repository;

	// Save Expression entity in the h2 database.
	public void save(final MathExpression exp) {
		repository.save(exp);
	}

	// Get all expressions from the h2 database.
	public List<MathExpression> getAll() {
		final List<MathExpression> expressions = new ArrayList<>();
		repository.findAll().forEach(exp -> expressions.add(exp));
		return expressions;
	}
	// convert to MathExpression Object from String expression
	public MathExpression convertExp(String exp) {
		MathExpression mathExpression = new MathExpression();
		mathExpression.setExp(exp);
		return mathExpression;		
	}
	//calculate the value of an expression
	public String calulateExp(MathExpression exp) {
		JEP myParser = new JEP();
		myParser.addStandardFunctions();
		myParser.addStandardConstants();
		myParser.setAllowUndeclared(true);
		myParser.parseExpression(exp.getexp());
		double result = myParser.getValue();
		return String.valueOf(result);	
	}
	// get all expressions
	public List<String> getAllString(){
		final List<String> expressions = new ArrayList<>();
		repository.findAll().forEach(exp -> expressions.add(exp.getexp()));
		return expressions;
	}
}
