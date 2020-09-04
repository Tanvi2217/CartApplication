package p3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import db.MyDatabase;


public class DisplayProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ---- read information from request parameter
		Product p = MyDatabase.getProductInfo(req.getParameter("keyword"), req.getParameter("name"));
		resp.getWriter().append(p.getProductName()+" - "+p.getCost());
		//----
	}
	
  

}
