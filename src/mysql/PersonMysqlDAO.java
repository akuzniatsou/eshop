package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import domain.Person;

public class PersonMysqlDAO implements PersonDAO {

	public static final String PERSON_BY_ID = "SELECT name,surname,email,address,phone FROM person WHERE id = ?";
	public static final String ALL_PERSON = "SELECT id,name,surname,email,address,phone FROM person";
	public static final String INSERT_PERSON = "INSERT INTO person (name,surname,email,address,phone) VALUES (?,?,?,?,?)";
	public static final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id=?";
	public static final String UPDATE_PERSON_BY_ID = "UPDATE person SET name=?,surname=?,email=?,address=?,phone=? WHERE id=?";


	
	@Override
	public Integer create(Person person) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(INSERT_PERSON,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getSurname());
		pstmt.setString(3, person.getEmail());
		pstmt.setString(4, person.getAddress());
		pstmt.setString(5, person.getPhone());
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
		} return null;
	}

	@Override
	public Person read(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		pstmt = con.prepareStatement(PERSON_BY_ID);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		Person person = null;
		if (rs.next()) {
			person = new Person();
			person.setName(rs.getString(1));
			person.setSurname(rs.getString(2));
			person.setEmail(rs.getString(3));
			person.setAddress(rs.getString(4));
			person.setPhone(rs.getString(5));
			person.setId(id);
		} return person;
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
	public void update(Person person) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		try{
		pstmt = con.prepareStatement(UPDATE_PERSON_BY_ID);
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getSurname());
		pstmt.setString(3, person.getEmail());
		pstmt.setString(4, person.getAddress());
		pstmt.setString(5, person.getPhone());
		pstmt.setInt(6, person.getId());
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
		pstmt = con.prepareStatement(DELETE_PERSON_BY_ID);
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
	public List<Person> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
		stmt = con.createStatement();
		rs = stmt.executeQuery(ALL_PERSON);
		List<Person> result = new ArrayList<Person>();
		while (rs.next()) {
			Person person = new Person();
			person.setId(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setSurname(rs.getString(3));
			person.setEmail(rs.getString(4));
			person.setAddress(rs.getString(5));
			person.setPhone(rs.getString(6));
			result.add(person);
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