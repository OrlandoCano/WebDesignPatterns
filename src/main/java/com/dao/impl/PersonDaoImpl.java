package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.PersonDao;
import com.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Person findById(Long id) {
		return jdbcTemplate.queryForObject(
                "SELECT id, name, email FROM person WHERE id = ?", new Object[] { id },
                (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name"), rs.getString("email"))
        );
	}

	@Override
	public List<Person> findAll() {
		return jdbcTemplate.query(
                "SELECT id, name, email FROM person",
                (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name"), rs.getString("email")));
	}

	@Override
	public Person save(Person person) {
		jdbcTemplate.update("INSERT INTO person (id, name, email) VALUES (?, ?, ?)", new Object[]{person.getId(), person.getName(), person.getEmail()});
		return person;
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
	}
}
