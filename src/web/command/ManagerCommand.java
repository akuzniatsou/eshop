package web.command;

import java.util.ArrayList;
import java.util.List;

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
import domain.Brand;
import domain.Product;
import domain.Type;
import exception.MyException;

public class ManagerCommand implements Command {
	ProductDAO productDao = new ProductMysqlDAO();
	TypeDAO typeDao = new TypeMysqlDAO();
	BrandDAO brandDao = new BrandMysqlDAO();
	ProductService productService = new ProductServiceImpl(productDao);
	TypeService typeService = new TypeServiceImpl(typeDao);
	BrandService brandService = new BrandServiceImpl(brandDao);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {ConnectionPool.getInstance().init();} catch (MyException e) {e.printStackTrace();}
		HttpSession session = req.getSession();
		String page = null;
		Brand brand = new Brand();
		Type type = new Type();
		List<Product> products = new ArrayList<Product>();
		if (req.getParameter("delete") != null) {
			productService.delete(Integer.parseInt(req.getParameter("delete")));
		}

		
/*		if (req.getParameter("update") != null) {
			Integer id = Integer.parseInt(req.getParameter("update"));
			Product product = productService.findById(id);
			if (product != null) {
				products.add(product);
				show(products);
				session.setAttribute("products", products);
				page = PageManager.getInstance().getProperty(PageManager.EDIT_PAGE);
				return page;
			}
		}*/
		/*	Get list of all products 
		*	and set session attribute "products" which contains
		*	collection all products from ProductDAO
		*/
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

			page = PageManager.getInstance().getProperty(PageManager.LIST_PAGE);
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
