package service;

import java.util.List;

import domain.Product;

public interface ProductService {

	List<Product> findAll();
	
	List<Product> searchByName(String name);
	
	List<Product> searchByDesc(String desc);
	
	Product findById(Integer identity);

	void save(Product product);

	void delete(Integer identity);

}
