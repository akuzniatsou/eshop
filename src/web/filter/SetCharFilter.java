package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharFilter implements Filter{
	private FilterConfig filterConfig = null;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain next) throws IOException, ServletException {
		String encoding = request.getCharacterEncoding();
		if(! "UTF-8".equalsIgnoreCase(encoding)){
			response.setCharacterEncoding("UTF-8");
		}
		next.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg) throws ServletException {
		this.setFilterConfig(arg);
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

}
