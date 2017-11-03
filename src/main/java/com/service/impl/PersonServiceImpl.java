package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonDao;
import com.model.Person;
import com.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDao dao;

	@Override
	public Person findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Person> findAll() {
		return dao.findAll();
	}

	@Override
	public Person save(Person person) {
		return dao.save(person);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
}
