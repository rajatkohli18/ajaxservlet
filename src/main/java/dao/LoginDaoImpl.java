package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Login;
import utility.JdbcConnection;

public class LoginDaoImpl implements LoginDao {
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;
	
	private static LoginDaoImpl obj = null;
	public static LoginDaoImpl getInstance()
	{
		if (obj == null)
			obj = new LoginDaoImpl();
		return obj;
	}
	private Connection getConnection()
	{
		return JdbcConnection.getInstance().getConnection();
		
	}

	@Override
	public boolean userExists(String username, String password) {
		boolean isValid = false;
		try {
			connection = getConnection();
			String Query = "Select username, password from userlogin where username = ? and password = ?";
			pstmnt = connection.prepareStatement(Query);
			pstmnt.setString(1, username);
			pstmnt.setString(2, password);
			resSet = pstmnt.executeQuery();
			if (resSet.next())
				isValid = true;
		} catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return isValid;

	}

	@Override
	public ArrayList<Login> fetchAllUser() {
		ArrayList<Login> usersList = new ArrayList<>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from userlogin";
			resSet = stmnt.executeQuery(query);
			while(resSet.next())
			{
				
				String username = resSet.getString("username");
				
				String password = resSet.getString("password");
				
				usersList.add(new Login(username,password));
				
			}
			return usersList;
			
		}
		catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");
			return null;

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
				if (resSet != null)
					resSet.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public boolean insertUser(Login login) {
		try {
			connection = getConnection();
			String query = "insert into users(username,age,gender,email,password)values(?,?,?,?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setString(1, login.getUsername());
			pstmnt.setString(2, login.getPassword());
			pstmnt.executeUpdate();
			System.out.println("ADDED!!");
			return true;

		} catch (SQLException sqle) {
			System.out.println(" NOT ADDED!!");
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}