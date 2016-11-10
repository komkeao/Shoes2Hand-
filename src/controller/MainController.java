package controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDB;
import model.ProductType;
import model.ProductTypeDB;

@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDB productDB = new ProductDB();
		
		ArrayList<Product> list = productDB.getProductListLimitsOrderByPID(10);
		request.setAttribute("list", list);
		
		ProductTypeDB db= new ProductTypeDB();
		
		ArrayList<ProductType> productType =db.getListType();
		request.setAttribute("productType",productType);
		request.setAttribute("price", productDB.getRangePrice());
		
		RequestDispatcher view = request.getRequestDispatcher("index" + ".jsp");
		view.forward(request, response);
	}

}
