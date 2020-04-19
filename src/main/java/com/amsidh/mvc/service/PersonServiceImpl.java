package com.amsidh.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.PersonDao;
import com.amsidh.mvc.entities.Person;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	public Integer countPersons() {
		
		return personDao.countPersons();
	}

	public List<Person> findPersons(int startPosition, int maxResults,
			String sortFields, String sortDirections) {
		return personDao.findPersons(startPosition, maxResults, sortFields, sortDirections);
	}

	@Override
	public Person find(Long id) {
		
		return personDao.find(id);
	}

	@Override
	public void remove(Person person) {
		personDao.remove(person);
		
	}

	@Override
	public Person save(Person person) {
		return personDao.save(person);
		
	}
	

	
	
	/*private static final List<Person> personList=new ArrayList<Person>();
	static{
		personList.add(new Person(1L, "Uzumaki Naruto", "Konoha"));
		personList.add(new Person(2L, "Hatake Kakashi", "Konoha"));
		personList.add(new Person(3L, "Haruno Sakura", "Konoha"));
		personList.add(new Person(4L, "Uchiha Sasuke", "Missing-nin"));
		personList.add(new Person(5L, "Gaara", "Sunagakure"));
		personList.add(new Person(6L, "Killer Bee", "Kumogakure"));
		personList.add(new Person(7L, "Jiraya", "Konoha"));
		personList.add(new Person(8L, "Namikaze Minato", "Konoha"));
		personList.add(new Person(9L, "Uchiha Madara", "Missing-nin"));
		personList.add(new Person(10L, "Senju Hashirama", "Konoha"));
		personList.add(new Person(11L, "Might Guy", "Konoha"));
		personList.add(new Person(12L, "Hyuga Neji", "Konoha"));
		personList.add(new Person(13L, "Rock Lee", "Konoha"));
		personList.add(new Person(14L, "Uchiha Obito", "Missing-nin"));
		personList.add(new Person(15L, "Kurama", "Tailed Beast"));
		personList.add(new Person(16L, "Uzumaki Kushina", "Konoha"));
		personList.add(new Person(17L, "Nara Shikamaru", "Konoha"));
		personList.add(new Person(18L, "Sarutobi Hiruzen", "Konoha"));
		personList.add(new Person(19L, "Tsunade", "Konoha"));
		personList.add(new Person(20L, "Orochimaru", "Missing-nin"));
		personList.add(new Person(21L, "Uchicha Itachi", "Missing-nin"));


		
				
	}
	public Integer countPersons() {
		
		return personList.size();
	}
	
	public List<Person> findPersons(int startPosition, int maxResults,
			String sortFields, String sortDirections) {
		try
		{
			return personList.subList(startPosition, startPosition + maxResults);	
		}catch(IndexOutOfBoundsException iobe)
		{
			return personList.subList(startPosition, personList.size());
		}
		
	}*/
}
