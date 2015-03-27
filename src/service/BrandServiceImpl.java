package service;

import java.util.List;

import dao.BrandDAO;
import domain.Brand;

public class BrandServiceImpl implements BrandService {
	BrandDAO brandDao;

	public BrandServiceImpl(BrandDAO brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public List<Brand> findAll() {
		return brandDao.readAll();
	}

	@Override
	public Brand findById(Integer id) {
		return brandDao.read(id);
	}

	@Override
	public void save(Brand brand) {
		if (brand.getId() != null) {
			brandDao.update(brand);
		} else {
			brandDao.create(brand);
		}
	}

	@Override
	public void delete(Integer id) {
		brandDao.delete(id);
	}

}
