package service;

import java.util.List;

import domain.Type;

public interface TypeService {

	List<Type> findAll();

	Type findById(Integer id);

	void save(Type type);

	void delete(Integer id);

}