package lti.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;

public class UserDaoImpl implements UserDao {

	private Connection getConnection() throws SQLException {
	//specific to a Database
		/*DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "quiz", "servlet");
		return conn;*/
		
	// Server level
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/quiz");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		String sql = "select * from users where email = ? and password = ?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());

			ResultSet rs = stmt.executeQuery();
			RegisterBean user = null;
			if (rs.next()) {
				user = new RegisterBean();
				user.setEmail(rs.getString(1));
				user.setProfile(rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean register(RegisterBean register) {
		String sql = "insert into users values (?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, register.getEmail());
			stmt.setString(2, register.getPassword());
			stmt.setString(3, register.getAnswer());
			stmt.setString(4, register.getProfile());

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validate(ForgetBean forget) {
		String sql = "select * from users where email = ? and answer = ?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, forget.getEmail());
			stmt.setString(2, forget.getAnswer());
			ResultSet rs = stmt.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean update(LoginBean change) {
		String sql = "update users set password = ? where email =?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(2, change.getEmail());
			stmt.setString(1, change.getPassword());
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
