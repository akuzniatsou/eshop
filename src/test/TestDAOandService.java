package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mysql.BrandMysqlDAO;
import mysql.ConnectionPool;
import mysql.ProductMysqlDAO;
import mysql.RoleMysqlDAO;
import mysql.TypeMysqlDAO;
import mysql.UserMysqlDAO;
import service.BrandService;
import service.BrandServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.RoleService;
import service.RoleServiceImpl;
import service.TypeService;
import service.TypeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import web.PageManager;
import dao.BrandDAO;
import dao.ProductDAO;
import dao.TypeDAO;
import dao.UserDAO;
import domain.Brand;
import domain.Product;
import domain.Type;
import domain.User;



public class TestDAOandService {


	public static void main(String args[])
	{
		ConnectionPool.getInstance();
		
		ProductDAO productDao = new ProductMysqlDAO();
		TypeDAO typeDao = new TypeMysqlDAO();
		BrandDAO brandDao = new BrandMysqlDAO();
		UserDAO userDao = new UserMysqlDAO();
		ProductService productService = new ProductServiceImpl(productDao);
		TypeService typeService = new TypeServiceImpl(typeDao);
		BrandService brandService = new BrandServiceImpl(brandDao);
		UserService userService = new UserServiceImpl(userDao);
		RoleService roleService = new RoleServiceImpl(new RoleMysqlDAO());


		for (User user : userService.findAll()){
			System.out.println(user);
		}
		
		
		for (Brand brand : brandService.findAll()){
			System.out.println(brand);
		}


	}
}  
