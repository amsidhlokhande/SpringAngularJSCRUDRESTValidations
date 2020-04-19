package com.amsidh.mvc.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amsidh.mvc.entities.Person;
@Transactional(readOnly=true)
@Repository
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Autowired
	public PersonDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	
	public Integer countPersons() {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from Person");
		Integer count=query.list().size();
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Person> findPersons(int startPosition, int maxResults,
			String sortFields, String sortDirections) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.getNamedQuery("person.paginated.query");
		query.setParameter("sortFields", sortFields);
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResults);
		List<Person> personList=query.list();
		
		if(sortDirections.equalsIgnoreCase("DESC"))
		{
			Collections.reverse(personList);
		}
		return personList;
	}


	@Override
	public Person find(Long id) {
		Session session = getSessionFactory().openSession();
		return (Person)session.get(Person.class, id);
	}

	@Transactional(readOnly=false,rollbackFor=Exception.class)
	@Override
	public void remove(Person person) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(person);
		session.getTransaction().commit();
		
	}


	@Transactional(readOnly=false,rollbackFor=Exception.class)
	@Override
	public Person save(Person person) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(person);
		session.getTransaction().commit();
		return person;
	}
	
	
}
