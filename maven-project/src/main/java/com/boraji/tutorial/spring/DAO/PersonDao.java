package com.boraji.tutorial.spring.DAO;

import java.util.List;

import com.boraji.tutorial.spring.entity.Person;

public interface PersonDao {
	
	void add(Person person);
	List<Person> listPersons();
	
}