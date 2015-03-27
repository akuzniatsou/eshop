package web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Command;
import web.PageManager;


public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest req,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			session.invalidate();
//			page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);
		}		

		page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);
		return page;
	}

}
