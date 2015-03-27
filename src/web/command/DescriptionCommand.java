package web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.BrandMysqlDAO;
import mysql.ConnectionPool;
import mysql.ProductMysqlDAO;
import mysql.TypeMysqlDAO;
import service.BrandService;
import service.BrandServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.TypeService;
import service.TypeServiceImpl;
import web.Command;
import web.PageManager;
import dao.BrandDAO;
import dao.ProductDAO;
import dao.TypeDAO;
import domain.Product;
import exception.MyException;

public class DescriptionCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
										throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			ConnectionPool.getInstance().init();
		} catch (MyException e) {
		}
		ProductDAO productDao = new ProductMysqlDAO();
		TypeDAO typeDao = new TypeMysqlDAO();
		BrandDAO brandDao = new BrandMysqlDAO();
		ProductService productService = new ProductServiceImpl(productDao);
		TypeService typeService = new TypeServiceImpl(typeDao);
		BrandService brandService = new BrandServiceImpl(brandDao);

		String page = null;
		try {
			String product_id = req.getParameter("idProduct");
			Product product = productService.findById(Integer.parseInt(product_id));
			product.setType(typeService.findById(product.getType().getId()));
			product.setBrand(brandService.findById(product.getBrand().getId()));
			product.setId(Integer.parseInt(product_id));
			session.setAttribute("product", product);
			page = PageManager.getInstance().getProperty(PageManager.DESCRIPTION_PAGE);
			return page;
		} catch (NullPointerException e){
		} 	page = PageManager.getInstance().getProperty(PageManager.CATALOG_PAGE);
			return page;
			}		
}
