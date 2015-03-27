package service;

import java.util.List;

import dao.ProductDAO;
import domain.Product;

public class ProductServiceImpl implements ProductService {
	ProductDAO productDao;

	public ProductServiceImpl(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() {
		return productDao.readAll();
	}

	@Override
	public Product findById(Integer id) {
		return productDao.read(id);
	}

	@Override
	public void save(Product product) {
		if (product.getId() != null) {
			productDao.update(product);
		} else {
			Integer id = productDao.create(product);
			product.setId(id);
		}
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> searchByName(String name) {
		return productDao.readByName(name);
	}

	@Override
	public List<Product> searchByDesc(String desc) {
		return productDao.readByDesc(desc);
	}


}
