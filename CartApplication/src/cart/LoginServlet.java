package cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doThings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// DAO
		if(username.equals("ramesh")&&password.equals("123"))
		{
			// ---- create a session
			HttpSession session = request.getSession(true); // always create new session
			// session -> attributes -> null
			// the representation of HashMap.
			List<Product> cartList = new ArrayList<>();
			session.setAttribute("username",username);
			session.setAttribute("accountNumber",101);
			session.setAttribute("role", "customer");
			session.setAttribute("cart", cartList);
			
			request.getRequestDispatcher("UserPageServlet").forward(request, response);
			
			// move user to UserPageServlet
		}
		else
		{
			// for wrong users
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doThings(request, response);
	}//end doPost
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doThings(request, response);
	}

}