package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Command;
import web.PageManager;


public class IndexCommand implements Command {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();

		String page = null;

		page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);

		return page;
	}
}

