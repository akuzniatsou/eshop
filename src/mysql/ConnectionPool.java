package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import exception.MyException;

final public class ConnectionPool {
	private String serverName = "localhost";
	private String mydatabase = "shop";
	private String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	private String driver = "com.mysql.jdbc.Driver";
	private String username = "shop";
	private String password = "shop";

	private BlockingQueue<Connection> connections = new LinkedBlockingQueue<Connection>();

	private ConnectionPool() {
	}

	synchronized public Connection getConnection(){
		Connection connection = null;
		Properties properties = new Properties();
        properties.setProperty("user",username);
        properties.setProperty("password",password);
		properties.setProperty("useUnicode","true");
		properties.setProperty("characterEncoding","UTF-8");
		while (connection == null) {
			try {
				if (connections.isEmpty()) {
					connection = DriverManager.getConnection(url, properties);
				} else {
					connection = connections.take();
					if (!connection.isValid(0)) {
						connection = null;
					}
				}
			} catch (InterruptedException e) {
				
			} catch (SQLException e) {
							}
		}
		return connection;
	}

	public void freeConnection(Connection connection) {
		try {
			connections.put(connection);
		} catch (InterruptedException e) {
		}
	}

	public void init() throws MyException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new MyException();
		}
	}

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}
}
