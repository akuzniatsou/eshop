package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BrandDAO;
import domain.Brand;

public class BrandMysqlDAO implements BrandDAO {

	public static final String BRAND_BY_ID = "SELECT product_brand FROM brand WHERE id = ?";
	public static final String ALL_BRAND = "SELECT id,product_brand FROM brand";
	public static final String INSERT_BRAND = "INSERT INTO brand (product_brand) VALUES (?)";
	public static final String DELETE_BRAND_BY_ID = "DELETE FROM brand WHERE id = ?";
	public static final String UPDATE_BRAND_BY_ID = "UPDATE brand SET product_brand=? WHERE id=?";

	@Override
	public Integer create(Brand brand) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(INSERT_BRAND,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, brand.getBrandName());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pool.freeConnection(con);
		}
		return null;
	}

	@Override
	public Brand read(Integer id){
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(BRAND_BY_ID);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		Brand brand = null;
		if (rs.next()) {
			brand = new Brand();
			brand.setBrandName(rs.getString(1));
			brand.setId(id);
		} return brand;
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
	public void update(Brand brand) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try{
		pstmt = con.prepareStatement(UPDATE_BRAND_BY_ID);
		pstmt.setString(1, brand.getBrandName());
		pstmt.setInt(2, brand.getId());
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
	public void delete(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_BRAND_BY_ID);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			pool.freeConnection(con);
		}
	}

	@Override
	public List<Brand> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ALL_BRAND);
			List<Brand> result = new ArrayList<Brand>();
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt(1));
				brand.setBrandName(rs.getString(2));
				result.add(brand);
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
}
