package com.springboot.h2.ctrl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.model.Oprator;
import com.springboot.h2.serv.OpratorService;

@RestController		// Useful to create the RESTful webservices.
public class OpratorController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	OpratorService service;

	// Get operator with maximum frequency from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/operators", produces= "application/vnd.jcg.api.v1+json")
	public Oprator getMaxOccurOperator() {
		log.info("Getting operator details from the database.");
		return service.getOpratorWithMaxCount();
	}
	@GetMapping(value= "/operators/all", produces= "application/vnd.jcg.api.v1+json")
	public List<Oprator> getOperators() {
		log.info("Getting operator details from the database.");
		return service.getAll();
	}
}
