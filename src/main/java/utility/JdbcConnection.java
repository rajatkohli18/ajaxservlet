package utility;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JdbcConnection {

		String url = "jdbc:mysql://localhost:3306/library";
		String user = "root";
		String password = "hitperson@123";

		private static JdbcConnection con = null;

		private JdbcConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("SORRY SQL CONNECTION CANNOT BE INSTANTIATED !!!");
			}
		}

		public Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return conn;
		}

		public static JdbcConnection getInstance() {
			if (con == null) {
				con = new JdbcConnection();
			}
			return con;
		}

	}



