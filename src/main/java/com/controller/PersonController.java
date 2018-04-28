package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.PersonService;

@RestController
@RequestMapping("/api/")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET) 
	public Person getPerson(@PathVariable Long id){
		return personService.findById(id);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET) 
	public List<Person> getPeople(){
		return personService.findAll();
	}
	@RequestMapping(value = "/person", method = RequestMethod.POST) 
	public @ResponseBody Person addPerson(@RequestBody Person person){
		return personService.save(person);
	}
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE) 
	public void deletePerson(@PathVariable Long id, HttpServletResponse response){
		personService.delete(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
}
