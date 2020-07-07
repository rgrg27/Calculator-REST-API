package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.model.MathExpression;
import com.springboot.h2.model.Oprator;
import com.springboot.h2.repo.OpratorRepository;

@Service
public class OpratorService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	OpratorRepository repository;

	// Save Oprator entity in the h2 database.
	public void save(final Oprator oprator) {
		repository.save(oprator);
	}

	// Get all Oprators from the h2 database.
	public List<Oprator> getAll() {
		final List<Oprator> oprators = new ArrayList<>();
		repository.findAll().forEach(oprator -> oprators.add(oprator));
		return oprators;
	}
	public Oprator findOpearorByName(char name) {
		final List<Oprator> oprators = getAll();
		for(Oprator oprator : oprators) {
			if(oprator.getName()==name) {
				return oprator;
			}
		}
		return null;
	}
	public void updateOpratorCount(char name, int addCount) {
		Oprator oprator = findOpearorByName(name);
		if(oprator==null) {
			Oprator newOprator = new Oprator();
			newOprator.setCount(addCount);
			newOprator.setName(name);
			save(newOprator);
		}
		else {
			int id = oprator.getId();
			int updatedCount = addCount+oprator.getCount();
			oprator.setCount(updatedCount);
			repository.deleteById(id);
			save(oprator);
		}
	}
	public Oprator getOpratorWithMaxCount() {
		final List<Oprator> oprators = getAll();
		Oprator opratorMax = new Oprator();
		opratorMax.setCount(0);
		for(Oprator oprator :oprators) {
			if(oprator.getCount()>opratorMax.getCount()) {
				opratorMax = oprator;
			}
		}
		return opratorMax;
	}

	public void updateOpratorTable(MathExpression exp) {
		String expression = exp.getexp();
		for(int i=0; i < expression.length(); i++) {
		     Boolean flag = Character.isDigit(expression.charAt(i));
		     if(!flag) {
		        updateOpratorCount(expression.charAt(i), 1);
		     }
		}		
	}	
}
