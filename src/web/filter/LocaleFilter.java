package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LocaleFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest req,ServletResponse resp, FilterChain next)

			throws IOException, ServletException {

			// чтение кодировки из запроса

			if (req.getParameter("locale") != null)
			{session.setAttribute("loc", req.getParameter("locale"));}

			// установка UTF-8, если не установлена

			if (!"UTF-8".equalsIgnorCase(encoding))

			resp.setCharacterEncoding("UTF-8");

			next.doFilter(req, resp);

			}

			public void destroy() {

			}

			}