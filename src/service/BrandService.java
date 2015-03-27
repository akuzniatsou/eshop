package service;

import java.util.List;

import domain.Brand;

public interface BrandService {

	List<Brand> findAll();

	Brand findById(Integer id);

	void save(Brand brand);

	void delete(Integer id);

}
