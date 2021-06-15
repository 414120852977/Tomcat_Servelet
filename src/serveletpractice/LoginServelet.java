package serveletpractice;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet(
		description = "Login Servelet Testing",
		urlPatterns = {"/LoginServelet"},
		initParams = {
				@WebInitParm(name = "user", value="Ashok"),
				@WebInitParm(name = "password", value="sai@123")
				
		}
		
		)
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		//get servlet config init parameters
		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		String nameRegex = "^[A-Z][1][A-Za-z]{2,15}";
		if(user.equals(nameRegex) && (password.equals(pwd))) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
			
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong</font>");
			rd.include(request, response);
		}
	}

}
