package dao;

import java.util.ArrayList;

import model.Login;



public interface LoginDao {
	boolean userExists(String userName, String password);
	ArrayList<Login> fetchAllUser();
	boolean insertUser(Login login);
}

