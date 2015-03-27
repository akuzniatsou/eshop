package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RoleDAO;
import domain.UserRole;

public class RoleMysqlDAO implements RoleDAO {

	public static final String ROLE_BY_ID = "SELECT role FROM user_role WHERE id = ?";
	public static final String ALL_ROLE = "SELECT id,role FROM user_role";
//	public static final String INSERT_ROLE = "INSERT INTO brand (product_brand) VALUES (?)";
//	public static final String DELETE_ROLE_BY_ID = "DELETE FROM brand WHERE id = ?";
//	public static final String UPDATE_ROLE_BY_ID = "UPDATE brand SET product_brand=? WHERE id=?";
	

	@Override
	public Integer create(UserRole entity){
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public UserRole read(Integer id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(ROLE_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			UserRole role = null;
			if (rs.next()) {
				role = new UserRole();
				role.setRoleName(rs.getString(1));
				role.setId(id);
			}
			return role;
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
	public void update(UserRole entity){
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id){
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserRole> readAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ALL_ROLE);
			List<UserRole> result = new ArrayList<UserRole>();
			while (rs.next()) {
				UserRole role = new UserRole();
				role.setId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				result.add(role);
			}
			return result;
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				stmt.close();
			} catch (SQLException e) {e.printStackTrace();}
			pool.freeConnection(con);
		}
		return null;
	}

}
