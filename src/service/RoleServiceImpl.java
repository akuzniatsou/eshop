package service;

import java.util.List;

import dao.RoleDAO;
import dao.UserDAO;
import domain.User;
import domain.UserRole;

public class RoleServiceImpl implements RoleService {
	RoleDAO roleDao;
	UserDAO userDao;
	User u = null;

	
	public RoleServiceImpl(RoleDAO roleDao) {
		super();
		this.roleDao = roleDao;
	}

	@Override
	public List<UserRole> findAll(){
		return roleDao.readAll();
	}

	@Override
	public UserRole findById(Integer id){
		return roleDao.read(id);
	}


}
