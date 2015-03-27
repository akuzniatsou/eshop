package service;

import java.util.List;

import dao.PersonDAO;
import dao.RoleDAO;
import dao.UserDAO;
import domain.User;
import domain.UserRole;

public class UserServiceImpl implements UserService {

	UserDAO userDao;
	RoleDAO roleDao;
	PersonDAO personDao;

	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public List<User> findAll(){
		return userDao.readAll();
	}

	@Override
	public List<User> findByRole(UserRole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id){
		// TODO Auto-generated method stub
		return userDao.read(id);
	}

	@Override
	public void save(User user){
	if(user.getId() != null) {
		userDao.update(user);
	} else {
		Integer id = userDao.create(user);
		user.setId(id);
        }

    }

	@Override
	public void delete(Integer id){
		userDao.delete(id);
	}

	@Override
	public User checkUser(String login, String pass){
		return userDao.read(login,pass);
	}


	
}
