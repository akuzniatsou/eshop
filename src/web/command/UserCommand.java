package web.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.ConnectionPool;
import mysql.PersonMysqlDAO;
import mysql.RoleMysqlDAO;
import mysql.UserMysqlDAO;
import service.PersonService;
import service.PersonServiceImpl;
import service.RoleService;
import service.RoleServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import web.Command;
import web.PageManager;
import dao.PersonDAO;
import dao.RoleDAO;
import dao.UserDAO;
import domain.Person;
import domain.User;
import domain.UserRole;
import exception.MyException;

public class UserCommand implements Command {

	UserDAO userDao = new UserMysqlDAO();
	RoleDAO roleDao = new RoleMysqlDAO();
	PersonDAO personDao = new PersonMysqlDAO();
	UserService userService = new UserServiceImpl(userDao);
	RoleService roleService = new RoleServiceImpl(roleDao);
	PersonService personService = new PersonServiceImpl(personDao);
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {ConnectionPool.getInstance().init();} catch (MyException e) {e.printStackTrace();}
		HttpSession session = req.getSession(false);
		String page = null;
		
		if (req.getParameter("delete") != null) {
			userService.delete(Integer.parseInt(req.getParameter("delete")));
		}
		
		
		List<User> users = show(userService.findAll());
		session.setAttribute("users", users);
		page = PageManager.getInstance().getProperty(PageManager.USERS_PAGE);
		return page;
	}	


	
	private List<User> show(List<User> users) {
		for (User user : users) {
			user.setRole(roleService.findById(user.getRole().getId()));
			user.setPerson(personService.findById(user.getPerson().getId()));
		}
		return users;
	}
	
	private User create(User user, Person person) {
		user.setPerson(person);
		userService.save(user);
			return user;
	}
	
	
}



