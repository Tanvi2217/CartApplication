package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;
import db.MyDatabase;

/**
 * Servlet implementation class UserPageServlet
 */
public class UserPageServlet extends HttpServlet {
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
		// getSession(false)-> provide old session otherwise create new one

		PrintWriter out = response.getWriter();
		
		if(session != null)
		{
			String username = (String) session.getAttribute("username");
			//String account = (String) session.getAttribute("account");
			//String role = (String) session.getAttribute("role");

			@SuppressWarnings("unchecked")
			List<Product> cartList = (List<Product>)session.getAttribute("cart");
			
			int cartSize = cartList.size();
			// welcome Ramesh
			
			// Product List DAO 
			
			List<Product> listProducts = MyDatabase.getProductsByKeyword("Laptop");
			List<Product> listProducts2 = MyDatabase.getProductsByKeyword("Watch");
			
			List<Product> allProducts = new ArrayList<>();
			allProducts.addAll(listProducts);
			allProducts.addAll(listProducts2);
			
			
			Iterator<Product> itr = allProducts.iterator();
			
			out.print("<HTML><BODY>");
			out.print("Welcome "+username+"<br/>");
			out.print("<hr/>");
			out.print("<b> Cart "+cartSize+"</b>");
			out.print("<hr/>");
			
			while(itr.hasNext())
			{
				Product p = itr.next();
				out.print(p.getProductName()+" - "+p.getCost()+"<a href='AddCartServlet?pname="+p.getProductName()+"'> Add to Cart </a>");
				out.print(p.getProductName()+" - "+p.getCost()+"<a href='RemoveCartServlet?pname="+p.getProductName()+"'> Remove from Cart </a>");
				out.print("<br/>");
			}
			
			out.print("<a href='DisplayCartServlet?pname='> Display Cart </a>");
			out.print("</BODY></HTML>");
			
		}
		else
		{
			response.sendRedirect("LoginPage.html");
		}
	}

}