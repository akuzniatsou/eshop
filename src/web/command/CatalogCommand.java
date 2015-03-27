package web.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class CatalogCommand implements Command {
	TypeDAO typeDao = new TypeMysqlDAO();
	BrandDAO brandDao = new BrandMysqlDAO();
	ProductDAO productDao = new ProductMysqlDAO();
	TypeService typeService = new TypeServiceImpl(typeDao);
	BrandService brandService = new BrandServiceImpl(brandDao);
	ProductService productService = new ProductServiceImpl(productDao);
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {ConnectionPool.getInstance().init();} catch (MyException e) {e.printStackTrace();}
		HttpSession session = req.getSession();
		List<Product> products = new ArrayList<Product>();
		String page = null;
		if (req.getParameter("addCart") != null){
			Map<Integer,Product> cart = new HashMap<Integer,Product>();
			session.setAttribute("cart", cart);
			}
		String searchName = req.getParameter("searchParamName");
		String searchDesc = req.getParameter("searchParamDesc");
		if (searchName != null){
			products = show(productService.searchByName(searchName));
		
		} else if (searchDesc != null){
			products = show(productService.searchByDesc(searchDesc));
		} else {
			products = show(productService.findAll());
			}
		
		session.setAttribute("products", products);
		if (products.isEmpty()){
			session.setAttribute("products", null);
			}
		page = PageManager.getInstance().getProperty(PageManager.CATALOG_PAGE);
		return page;
	}
	
	
	private List<Product> show(List<Product> products) {
		for (Product product : products) {
			product.setBrand(brandService.findById(product.getBrand().getId()));
			product.setType(typeService.findById(product.getType().getId()));
		}
		return products;
	}
}


