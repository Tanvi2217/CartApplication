package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;

/**
 * Servlet implementation class DisplayCartServlet
 */
public class DisplayCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doThings(request, response);
	}//end doPost
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doThings(request, response);
	}
	
	
	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		//String productName = request.getParameter("pname");
		
		if(session != null)
		{
			
			@SuppressWarnings("unchecked")
			List<Product> cartList = (List<Product>)session.getAttribute("cart");
			PrintWriter out = response.getWriter();
			out.print(cartList);
		}
		else
		{
			response.sendRedirect("LoginPage.html");
		}
	}
}
