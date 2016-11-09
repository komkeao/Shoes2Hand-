package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import model.ProductDB;
import model.ProductType;
import model.ProductTypeDB;

@WebServlet("/product")
@MultipartConfig
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ProductDB productDB = new ProductDB();
		ProductTypeDB db= new ProductTypeDB();
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		
		if (action.equals("insert")) {
			
			Product product = new Product();
			InputStream inputStream = null;
			Part filePart = request.getPart("photo");
			if (filePart != null) {
				inputStream = filePart.getInputStream();
			}

			product.setDescription(new String(request.getParameter(
					"description").getBytes("ISO8859_1"), "utf-8"));
			product.setpName(new String(request.getParameter("name").getBytes(
					"ISO8859_1"), "utf-8"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setStatus(0);
			product.setTypeID(Integer.parseInt(request.getParameter("type")));
			productDB.insert(product, inputStream);
			response.sendRedirect("product?action=add");

		} else if (action.equals("search")) {
			
			int price =Integer.parseInt(request.getParameter("price"));
			String[] typeID=request.getParameterValues("type");
			
			ArrayList<Product> list = productDB.getProductListByTypeAndPrice(price, typeID);
			request.setAttribute("list", list);
			
			ArrayList<ProductType> productType =db.getListType();
			request.setAttribute("productType",productType);
			RequestDispatcher view = request.getRequestDispatcher("index" + ".jsp");
			view.forward(request, response);

		} else if (action.equals("byType")) {
			
			int type =Integer.parseInt(request.getParameter("type"));
			ProductDB productDB1 = new ProductDB();
			ArrayList<Product> list = productDB1.getProductListByType(type);
			request.setAttribute("list", list);
			ArrayList<ProductType> productType =db.getListType();
			request.setAttribute("productType",productType);
			RequestDispatcher view = request.getRequestDispatcher("index" + ".jsp");
			view.forward(request, response);
			

		} else if (action.equals("updateStatus")) {

		} else if (action.equals("addType")) {
			ProductType productType = new ProductType();
			productType.setTypeName(new String(request.getParameter("typeName")
					.getBytes("ISO8859_1"), "utf-8"));
			db.insert(productType);

			response.sendRedirect("product?action=add");
		} else if(action.equals("add")) {

			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			RequestDispatcher view = request
					.getRequestDispatcher("productAdd.jsp");
			view.forward(request, response);
			
		} else if(action.equals("searchword")){
			
			String str =request.getParameter("word");
			ProductDB productDB1 = new ProductDB();
			ArrayList<Product> list = productDB1.searchProduct(str);
			request.setAttribute("list", list);
			ArrayList<ProductType> productType =db.getListType();
			request.setAttribute("productType",productType);
			RequestDispatcher view = request.getRequestDispatcher("index" + ".jsp");
			view.forward(request, response);
		}

	}

}
