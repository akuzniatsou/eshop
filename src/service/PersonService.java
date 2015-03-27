package service;

import java.util.List;

import domain.Person;

public interface PersonService {

	List<Person> findAll();

	Person findById(Integer id);

	void save(Person person);

	void delete(Integer id);

}
