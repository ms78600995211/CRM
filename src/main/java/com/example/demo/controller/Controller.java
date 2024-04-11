package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerDetails;
import com.example.demo.model.Model;

@RestController
public class Controller {

@Autowired
Model repo;	
	
	
@RequestMapping("/")	
public String testing() {
	return "this is just for tesing ...";	
}
	

@PostMapping("/add")
public CustomerDetails addCustomer(@RequestBody CustomerDetails details) {
	CustomerDetails addcust=repo.save(details);
	return addcust;
}

@GetMapping("/allDetails")
public List<CustomerDetails> getAllCustomer(){
	List<CustomerDetails> list=repo.findAll();
	return list;
}


}
