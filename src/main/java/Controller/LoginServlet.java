package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hdhf");
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String username=request.getParameter("username");  
		    String password=request.getParameter("password"); 
		    
		   if(LoginServiceImpl.getInstance().validateUser(username, password)) {
			   
					System.out.println("VALID!!!");
					response.setStatus(200);
				}
				else		
				{
					response.setStatus(401);
				}	
		   }
	}

