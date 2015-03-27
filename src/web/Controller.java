package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/controller")
public class Controller extends HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	CommandFactory commandFactory = CommandFactory.getInstance();

	public Controller() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
			Command command = commandFactory.getCommand(request);
			if (command != null) {
				page = command.execute(request, response);
			} else {
				page = commandFactory.getPage(request);
			}
		} catch (ServletException e) {
			e.printStackTrace();
			page = PageManager.getInstance().getProperty(PageManager.ERROR_PAGE);
		} catch (IOException e) {
			e.printStackTrace();
			page = PageManager.getInstance().getProperty(PageManager.ERROR_PAGE);
		}
		if (page == null){
			page = commandFactory.getPage(null);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
