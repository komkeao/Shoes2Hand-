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
import model.UserDB;

@WebServlet("/product")
@MultipartConfig  
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		ProductDB productDB = new ProductDB();
		if (action.equals("add")) {
			Product product=new Product();
			InputStream inputStream = null; 
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {          
	            inputStream = filePart.getInputStream();
	        }
			product.setDescription(new String(request.getParameter("description")
							.getBytes("ISO8859_1"), "utf-8"));
			product.setpName(new String(request.getParameter("name")
							.getBytes("ISO8859_1"), "utf-8"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setStatus(0);
			product.setTypeID(Integer.parseInt(request.getParameter("type")));
			productDB.insert(product,inputStream);
			response.sendRedirect("product");
			
		}else if(action.equals("update")){
			
		}else if(action.equals("delete")){
			
		}else if(action.equals("updateStatus")){
			
		}else if(action.equals("addType")){
			ProductType productType=new ProductType();
			productType.setTypeName(new String(request.getParameter("typeName")
							.getBytes("ISO8859_1"), "utf-8"));
			ProductTypeDB db=new ProductTypeDB();
			db.insert(productType);
			
			response.sendRedirect("product");
		}else{
			ProductTypeDB db= new ProductTypeDB();
			ArrayList<ProductType> productType =db.getListType();
			request.setAttribute("productType",productType);
			RequestDispatcher view = request.getRequestDispatcher("productAdd.jsp");
			view.forward(request, response);
		}

		
	}

}
