package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TypeDAO;
import domain.Type;

public class TypeMysqlDAO implements TypeDAO {

	public static final String TYPE_BY_ID = "SELECT product_type FROM type WHERE id = ?";
	public static final String ALL_TYPE = "SELECT id,product_type FROM type";
	public static final String INSERT_TYPE = "INSERT INTO type (product_type) VALUES (?)";
	public static final String DELETE_TYPE_BY_ID = "DELETE FROM type WHERE id = ?";
	public static final String UPDATE_TYPE_BY_ID = "UPDATE type SET product_type=? WHERE id=?";



	@Override
	public Integer create(Type type) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(INSERT_TYPE,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, type.getTypeName());
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		   if(rs.next()) {
		        return rs.getInt(1);
		    } return null;
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				pstmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			pool.freeConnection(con);
		}
		return null;
	}

	@Override
	public Type read(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(TYPE_BY_ID);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		Type type = null;
		if (rs.next()) {
			type = new Type();
			type.setTypeName(rs.getString(1));
			type.setId(id);
		} return type;
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
	public void update(Type type) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try{
		pstmt = con.prepareStatement(UPDATE_TYPE_BY_ID);
		pstmt.setString(1, type.getTypeName());
		pstmt.setInt(2, type.getId());
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
		try{
		pstmt = con.prepareStatement(DELETE_TYPE_BY_ID);
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
	public List<Type> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
		stmt = con.createStatement();
		rs = stmt.executeQuery(ALL_TYPE);
		List<Type> result = new ArrayList<Type>();
		while (rs.next()) {
			Type type = new Type();
			type.setId(rs.getInt(1));
			type.setTypeName(rs.getString(2));
			result.add(type);
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
