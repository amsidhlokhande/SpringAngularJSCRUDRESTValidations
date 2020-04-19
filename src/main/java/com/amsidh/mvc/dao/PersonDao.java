package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.entities.Person;

public interface PersonDao {
	public Integer countPersons();
	public List<Person> findPersons(int startPosition, int maxResults,String sortFields, String sortDirections);
	public Person find(Long id);
	public void remove(Person person);
	public Person save(Person person);
	
}
