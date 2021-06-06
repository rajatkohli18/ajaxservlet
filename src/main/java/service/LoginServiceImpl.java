package service;


import dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
static private LoginServiceImpl obj = null;
	
	public static LoginServiceImpl getInstance()
	{
		if(obj == null)
			obj = new LoginServiceImpl();
		return obj;
	}

	@Override
	public boolean validateUser(String username, String password) {
		return LoginDaoImpl.getInstance().userExists(username, password);
		
	}

}
