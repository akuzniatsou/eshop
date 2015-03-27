package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import domain.Brand;
import domain.Product;
import domain.Type;

public class ProductMysqlDAO implements ProductDAO {
	
	public static final String ALL_PRODUCT = "SELECT id,type_id,brand_id,name,cost,description FROM product";
	public static final String PRODUCT_BY_ID = "SELECT type_id,brand_id,name,cost,description FROM product WHERE id = ?";
	public static final String SEARCH_BY_NAME = "SELECT id,type_id,brand_id,name,cost,description FROM product WHERE name LIKE ?";
	public static final String SEARCH_BY_DESCRIPTION = "SELECT id,type_id,brand_id,name,cost,description FROM product WHERE description LIKE ?";
	public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id=?";


	
	public List<Product> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(ALL_PRODUCT);
			List<Product> result = new ArrayList<Product>();
			while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(4));
			product.setCost(rs.getDouble(5));
			product.setDescription(rs.getString(6));
			Type type = new Type();
			type.setId(rs.getInt(2));
			product.setType(type);
			Brand brand = new Brand();
			brand.setId(rs.getInt(3));
			product.setBrand(brand);
			result.add(product);
		} return result;
	} catch (SQLException e) {e.printStackTrace();
	} finally {
		try {
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		try {
			stmt.close();
		} catch (SQLException e) {e.printStackTrace();}
		pool.freeConnection(con);
	} return null;
}


	@Override
	public Integer create(Product entity) {
		return null;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_PRODUCT_BY_ID);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			pool.freeConnection(con);
		}
	}

	@Override
	public Product read(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(PRODUCT_BY_ID);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		Product product = null;
		if (rs.next()) {
			product = new Product();
			Type type = new Type();
			type.setId(rs.getInt(1));
			product.setType(type);
			Brand brand = new Brand();
			brand.setId(rs.getInt(2));
			product.setBrand(brand);
			product.setName(rs.getString(3));
			product.setCost(rs.getDouble(4));
			product.setDescription(rs.getString(5));
			product.setId(id);
		} return product;
		} catch (SQLException e) {
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				pstmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			pool.freeConnection(con);
		} return null;
	}


	@Override
	public List<Product> readByName(String name) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
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
		} return result;
	} catch (SQLException e) {e.printStackTrace();
	} finally {
		try {
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		try {
			pstmt.close();
		} catch (SQLException e) {e.printStackTrace();}
		pool.freeConnection(con);
	} return null;
}


	@Override
	public List<Product> readByDesc(String desc) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(SEARCH_BY_DESCRIPTION);
		pstmt.setString(1, "%"+desc+"%");
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
		} return result;
	} catch (SQLException e) {e.printStackTrace();
	} finally {
		try {
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		try {
			pstmt.close();
		} catch (SQLException e) {e.printStackTrace();}
		pool.freeConnection(con);
	} return null;
}
	
}
