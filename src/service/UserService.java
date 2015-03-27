package service;


import java.util.List;
import domain.User;
import domain.UserRole;


public interface UserService {
	
	List<User> findByRole(UserRole role);

	List<User> findAll();
	
	User findById(Integer identity);

	void save(User user);

	void delete(Integer identity);

	public User checkUser(String login, String pass);
	

}
