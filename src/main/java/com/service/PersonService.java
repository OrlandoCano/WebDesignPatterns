package com.service;

import java.util.List;

import com.model.Person;

public interface PersonService {
	
	Person findById(Long id);

	List<Person> findAll();

	Person save(Person person);

	void delete(Long id);

}
