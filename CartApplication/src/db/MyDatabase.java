package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import beans.Product;

public class MyDatabase {

	public static Map<String, List<Product>> products = new HashMap<String, List<Product>>();
	
	public static List<Product> laptopList = new ArrayList<>();
	public static List<Product> watchlist = new ArrayList<>();

	static {

		laptopList.add(new Product("Hp101", 2000));
		laptopList.add(new Product("Dell101", 3000));
		laptopList.add(new Product("Apple1", 20000));

		watchlist.add(new Product("Fasttrack1", 1000));
		watchlist.add(new Product("Fasttrack2", 3000));
		watchlist.add(new Product("Fasttrack3", 20000));

		products.put("Laptop", laptopList);
		products.put("Watch", watchlist);
		products.put("Mobile Phones", null);

	}

	public static Product getProductByName(String pname)
	{
		Iterator<String> itr_map = products.keySet().iterator();
	// SQL :  select * from Products where productName = ? and Keyword = ? and seller = ?;	
		while(itr_map.hasNext())
		{
			String keyword = itr_map.next(); // keyword
			
			List<Product> list = products.get(keyword);
			
			for(Product p:list)
			{
				if(pname.equals(p.getProductName()))
				{
					return p;
				}
			}
			
		}
		
		
		return null;
	}
	
	
	public static List<Product> getProductsByKeyword(String requestedkeyword) {
		Iterator<String> itr = products.keySet().iterator();

		while (itr.hasNext()) {
			String keyword = itr.next(); // key
			System.out.println(" --->> 3.1 inside while itr of map " + keyword);
			if (keyword.equals(requestedkeyword)) {
				System.out.println(" ---->> 4 inside while - if Keyword match " + keyword);
				List<Product> listOfProducts = products.get(keyword);

				return listOfProducts;

			}

		}
		return null;

	}

	public static Product getProductInfo(String keyword, String productName) {
		List<Product> list = null;
		if (keyword.equalsIgnoreCase("laptop")) {
			list = laptopList;
		}
		if (keyword.equalsIgnoreCase("watch")) {
			list = watchlist;
		}
		if (keyword.equalsIgnoreCase("mobile phone")) {
			list = null;
		}
		
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext())
		{
			Product p = itr.next();
			String pname = p.getProductName();
			if(pname.equalsIgnoreCase(productName)) return p;
		}
		return null;
	}

}