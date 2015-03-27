package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import domain.Person;
import domain.User;
import domain.UserRole;

public class UserMysqlDAO implements UserDAO {

	public static final String USER_BY_ID = "SELECT login,password,role_id,person_id FROM user WHERE id = ?";
	public static final String ALL_USER = "SELECT id,login,password,role_id,person_id FROM user ORDER BY role_id";
	public static final String INSERT_USER = "INSERT INTO user (login,password,role_id,person_id) VALUES (?,?,?,?)";
	public static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id=?";
	public static final String UPDATE_USER_BY_ID = "UPDATE user SET login=?,password=?,role_id=?,person_id=? WHERE id=?";
	public static final String CHECK_USER = "SELECT id,login,password,role_id,person_id FROM user WHERE login=? AND password=?";

	@Override
	public Integer create(User user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getLogin());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getRole().getId());
			pstmt.setInt(4, user.getPerson().getId());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
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
		} return null;
	}

	@Override
	public User read(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(USER_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			User user = null;
			if (rs.next()) {
				user = new User();
				user.setLogin(rs.getString(1));
				user.setPassword(rs.getString(2));
				UserRole role = new UserRole();
				role.setId(rs.getInt(3));
				user.setRole(role);
				Person person = new Person();
				person.setId(rs.getInt(4));
				user.setPerson(person);
				user.setId(id);
			} return user;
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
	public void update(User user){
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_USER_BY_ID);
			pstmt.setString(1, user.getLogin());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getRole().getId());
			pstmt.setInt(4, user.getPerson().getId());
			pstmt.setInt(5, user.getId());
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
	public void delete(Integer id){
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_USER_BY_ID);
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
	public List<User> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ALL_USER);
			List<User> result = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
				UserRole role = new UserRole();
				role.setId(rs.getInt(4));
				user.setRole(role);
				Person person = new Person();
				person.setId(rs.getInt(5));
				user.setPerson(person);
				result.add(user);
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
	public User read(String login, String pass){
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(CHECK_USER);
			pstmt.setString(1, login);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			User user = new User();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
			} 
			return user;
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
