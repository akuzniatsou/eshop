package web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.Command;
import web.PageManager;



public class NoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = PageManager.getInstance().getProperty(PageManager.INDEX_PAGE);
		return page;
	}

}
