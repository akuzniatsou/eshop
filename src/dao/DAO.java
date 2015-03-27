package dao;

import java.util.List;



public interface DAO<T> {

	public Integer create(T entity);

	public T read(Integer id);

	public void update(T entity);

	public void delete(Integer id);
	
	public List<T> readAll();

}