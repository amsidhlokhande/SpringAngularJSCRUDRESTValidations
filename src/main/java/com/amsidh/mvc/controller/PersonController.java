package com.amsidh.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amsidh.mvc.entities.Person;
import com.amsidh.mvc.service.PersonService;
import com.amsidh.mvc.util.PaginatedListWrapper;

@RestController
@RequestMapping("/resources/persons")
public class PersonController {

	private static final Logger logger = Logger
			.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	public PersonController() {
		System.out.println("PersonController is loading!!!!");
	}

	public PaginatedListWrapper<Person> findPersons(
			PaginatedListWrapper<Person> wrapper) {
		wrapper.setTotalResults(personService.countPersons());
		int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
		wrapper.setList(personService.findPersons(start, wrapper.getPageSize(),
				wrapper.getSortFields(), wrapper.getSortDirections()));
		return wrapper;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public PaginatedListWrapper<Person> listPersons(
			@RequestParam("page") Integer page,
			@RequestParam("sortFields") String sortFields,
			@RequestParam("sortDirections") String sortDirections) {
		System.out.println("listPersons Method");
		PaginatedListWrapper<Person> paginatedListWrapper = new PaginatedListWrapper<Person>();
		if (page != null) {
			paginatedListWrapper.setCurrentPage(page);
		} else {
			paginatedListWrapper.setCurrentPage(1);
		}
		if (sortFields != null && !sortFields.equals("")) {
			paginatedListWrapper.setSortFields(sortFields);
		} else {
			paginatedListWrapper.setSortFields("ID");
		}
		if (sortDirections != null && !sortDirections.equals("")) {
			paginatedListWrapper.setSortDirections(sortDirections);
		} else {
			paginatedListWrapper.setSortDirections("ASC");
		}

		paginatedListWrapper.setPageSize(5);
		return findPersons(paginatedListWrapper);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Person getPerson(@PathVariable("id") Long id) {
		return personService.find(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deletePerson(@PathVariable("id") Long id) {
		personService.remove(getPerson(id));
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Person savePerson(@RequestBody Person person) {
		Person savedPerson=personService.save(person);
		return savedPerson;

	}

}
