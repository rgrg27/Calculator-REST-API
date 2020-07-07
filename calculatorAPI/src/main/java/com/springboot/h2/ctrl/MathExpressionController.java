package com.springboot.h2.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.model.MathExpression;
import com.springboot.h2.serv.MathExpressionService;
import com.springboot.h2.serv.OpratorService;

@RestController		// Useful to create the RESTful webservices.
public class MathExpressionController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	MathExpressionService service;
	@Autowired
	OpratorService opratorService;

	// Save Operator entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value= "/expression")
	public String save(final@RequestBody @Valid MathExpression exp){
		service.save(exp);
		opratorService.updateOpratorTable(exp);
		return service.calulateExp(exp);
	}

	// Get all expressions from the database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/expression/all", produces= "application/vnd.jcg.api.v1+json")
	public List<String> getAll() {
		log.info("Getting expressions from the database.");
		return service.getAllString();
	}
}
