package service;

import java.util.List;

import dao.PersonDAO;
import domain.Person;

public class PersonServiceImpl implements PersonService {

	PersonDAO personDao;

	public PersonServiceImpl(PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}

	public List<Person> findAll() {
		return personDao.readAll();
	}

	public Person findById(Integer id) {
		return personDao.read(id);
	}

	public void save(Person person) {
		if(person.getId() != null) {
			personDao.update(person);
		} else {
			Integer id = personDao.create(person);
			person.setId(id);
	        }
	}

	public void delete(Integer id) {
		personDao.delete(id);
	}

	
	
}
