package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Brand;
import domain.Person;
import domain.Product;
import domain.Type;
import domain.User;
import domain.UserRole;

import mysql.ConnectionPool;
import exception.MyException;

public class TestJDBC {

	public static void main(String args[]) throws MyException, SQLException {
		
		final String BRAND_BY_ID = "SELECT product_brand FROM brand WHERE id = ?";
		final String ALL_BRAND = "SELECT id,product_brand FROM brand";
		final String INSERT_BRAND = "INSERT INTO brand (product_brand) VALUES (?)";
		final String DELETE_BRAND_BY_ID = "DELETE FROM brand WHERE id = ?";
		final String UPDATE_BRAND_BY_ID = "UPDATE brand SET product_brand=? WHERE id=?";
		final String ALL_PRODUCT = "SELECT id,type_id,brand_id,name,cost,description FROM product";
		final String PRODUCT_BY_ID = "SELECT type_id,brand_id,name,cost,description FROM product WHERE id = ?";
		final String SEARCH_BY_NAME = "SELECT id,type_id,brand_id,name,cost,description FROM product WHERE name LIKE ?";
	
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		Statement stmt = null;
		String name = "u";


		pstmt = con.prepareStatement(SEARCH_BY_NAME);
		pstmt.setString(1, "%"+name+"%");
		rs = pstmt.executeQuery();
		List<Product> result = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			Type type = new Type();
			type.setId(rs.getInt(2));
			product.setType(type);
			Brand brand = new Brand();
			brand.setId(rs.getInt(3));
			product.setBrand(brand);
			product.setName(rs.getString(4));
			product.setCost(rs.getDouble(5));
			product.setDescription(rs.getString(6));
			result.add(product);
		} 
			
		pool.freeConnection(con);
			
			for (Product b : result)
				{System.out.println(b);}
}
}
