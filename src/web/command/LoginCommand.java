package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.ConnectionPool;
import mysql.RoleMysqlDAO;
import mysql.UserMysqlDAO;
import service.RoleService;
import service.RoleServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import web.Command;
import web.PageManager;
import domain.User;
import domain.UserRole;
import exception.MyException;


public class LoginCommand implements Command {
	HttpSession session;
	UserService userService = new UserServiceImpl(new UserMysqlDAO());
	RoleService roleService = new RoleServiceImpl(new RoleMysqlDAO());
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String page = null;
		String currentRole = null;
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		session = req.getSession(false);

		try {
			ConnectionPool.getInstance().init();
		} catch (MyException e) {
		}
		
		if (session.getAttribute("role") == null)
		{
			String login = req.getParameter("login");
			String pass = req.getParameter("pass");
			User user = userService.checkUser(login, pass);
				if (null == user.getId()){
					req.setAttribute("error", " ");
					page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);
					if (session.getAttribute("pages") != null){
						String pages =(String) session.getAttribute("pages");
						page = changePage(page, pages);
					}
					return page;
				}
			user = userService.findById(user.getId());
			UserRole role = roleService.findById(user.getRole().getId());
			session.setAttribute("user", user.getLogin());
			session.setAttribute("role", role.getRoleName());
			currentRole = role.getRoleName();

		page = changePage(page, currentRole);
		} 	currentRole = (String) session.getAttribute("role");
			page = changePage(page, currentRole);
			return page;
	}

	private String changePage(String page, String param) {
		
		switch (param) {
		case "administrator":
			page = PageManager.getInstance().getProperty(PageManager.ADMIN_PAGE);
			break;
		case "manager":
			page = PageManager.getInstance().getProperty(PageManager.MANAGER_PAGE);
			break;
		case "customer":
			page = PageManager.getInstance().getProperty(PageManager.CUSTOMER_PAGE);
			break;
		case "info":
			page = PageManager.getInstance().getProperty(PageManager.INFO_PAGE);
			break;
		case "help":
			page = PageManager.getInstance().getProperty(PageManager.HELP_PAGE);
			break;
		case "reg":
			page = PageManager.getInstance().getProperty(PageManager.REGISTRATION_PAGE);
			break;
		case "contact":
			page = PageManager.getInstance().getProperty(PageManager.CONTACT_PAGE);
			break;
		default:
			page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);
			break;
		}
		return page;
	}
}
