package service;

import java.util.List;

import domain.UserRole;

public interface RoleService {

	List<UserRole> findAll();

	UserRole findById(Integer id);
	

}