package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import db.MyDatabase;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("---->> 1inside doGet");
		String requestedkeyword = request.getParameter("products_keyword");
		String location= request.getParameter("location");
		
		System.out.println(" --->> 2 " + requestedkeyword+" & "+location);
		// call DAO

		List<Product> productList = MyDatabase.getProductsByKeyword(requestedkeyword);

		Iterator<Product> availableProductsItr = productList.iterator();

		out.print("<ul> ");
		out.print(" List of Laptops in "+location);;
		while (availableProductsItr.hasNext()) {
			System.out.println(" ---->> 5 inside while for list itr");
			Product p = availableProductsItr.next();
			String productName = p.getProductName();

			out.print("<li><a href='DisplayProductServlet?keyword=" + requestedkeyword + "&name=" + productName + "'>"
					+ productName + "</a></li>");
		}
		out.print("</ul>");

	}//end doGet

	

}// end class
