package dao;

import java.util.List;

import domain.Product;

public interface ProductDAO extends DAO<Product> {

	public List<Product> readByName(String name);
	
	public List<Product> readByDesc(String desc);
}
