package web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.command.CatalogCommand;
import web.command.DescriptionCommand;
import web.command.IndexCommand;
import web.command.LoginCommand;
import web.command.LogoutCommand;
import web.command.ManagerCommand;
import web.command.UserCommand;



public class CommandFactory {
	private static CommandFactory instance = null;

	HashMap<String, Command> commands = new HashMap<String, Command>();
	HashMap<String, String> pages = new HashMap<String, String>();
	
	private CommandFactory() {

		commands.put("login", 			new LoginCommand());
		commands.put("logout", 			new LogoutCommand());
		
		commands.put("list", 			new ManagerCommand());
		commands.put("delete", 			new ManagerCommand());
		commands.put("addProduct", 		new ManagerCommand());
		commands.put("black", 			new ManagerCommand());
		
		commands.put("catalog", 		new CatalogCommand());

		commands.put("description", 	new DescriptionCommand());
		
		commands.put("index", 			new IndexCommand());
		commands.put("addCart", 		new IndexCommand());

		commands.put("listUser", 		new UserCommand());
		commands.put("addUser", 			new UserCommand());
		commands.put("delUser", 			new UserCommand());
		commands.put("modUser", 			new UserCommand());


		pages.put("help",PageManager.getInstance().getProperty(PageManager.HELP_PAGE));
		pages.put("info",PageManager.getInstance().getProperty(PageManager.INFO_PAGE));
		pages.put("reg",PageManager.getInstance().getProperty(PageManager.REGISTRATION_PAGE));
		pages.put("contact",PageManager.getInstance().getProperty(PageManager.CONTACT_PAGE));
		pages.put("index",PageManager.getInstance().getProperty(PageManager.INDEX_PAGE));
		pages.put("admin",PageManager.getInstance().getProperty(PageManager.ADMIN_PAGE));
		pages.put("manager",PageManager.getInstance().getProperty(PageManager.MANAGER_PAGE));
		pages.put("customer",PageManager.getInstance().getProperty(PageManager.CUSTOMER_PAGE));
		pages.put("catalog",PageManager.getInstance().getProperty(PageManager.CATALOG_PAGE));
		pages.put("list",PageManager.getInstance().getProperty(PageManager.LIST_PAGE));
		pages.put("cart",PageManager.getInstance().getProperty(PageManager.CART_PAGE));
		pages.put("edit",PageManager.getInstance().getProperty(PageManager.EDIT_PAGE));
		pages.put("userList",PageManager.getInstance().getProperty(PageManager.USERS_PAGE));
	}

	public Command getCommand(HttpServletRequest req) {
		String action = req.getParameter("command");
		HttpSession session = req.getSession(true);
		if (req.getParameter("locale") != null)
		{session.setAttribute("loc", req.getParameter("locale"));}
		Command command = commands.get(action);
		return command;
	}

	public String getPage(HttpServletRequest req) {
		String action;
		if (req != null) {
			action = req.getParameter("page");
			HttpSession session = req.getSession(true);
			session.setAttribute("pages", req.getParameter("page"));
			if (req.getParameter("locale") != null)
			{session.setAttribute("loc", req.getParameter("locale"));}
		} else {
			action = "index";
		}
		String page = pages.get(action);
		return page;
	}

	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
	}


}
