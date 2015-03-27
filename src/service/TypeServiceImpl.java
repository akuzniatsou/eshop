package service;

import java.util.List;

import dao.TypeDAO;
import domain.Type;

public class TypeServiceImpl implements TypeService {
	TypeDAO typeDao;
	
	public TypeServiceImpl(TypeDAO typeDao) {
		super();
		this.typeDao = typeDao;
	}

	@Override
	public List<Type> findAll(){
		return typeDao.readAll();
	}

	@Override
	public Type findById(Integer id){
		return typeDao.read(id);
	}

	@Override
	public void save(Type type){
		if(type.getId() != null) {
			typeDao.update(type);
		} else {
			Integer id = typeDao.create(type);
			type.setId(id);
	        }
    }

	@Override
	public void delete(Integer id){
		typeDao.delete(id);
	}

}
