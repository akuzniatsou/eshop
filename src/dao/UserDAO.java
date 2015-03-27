package dao;

import domain.User;


public interface UserDAO extends DAO<User> {

	public User read(String login, String pass);
}