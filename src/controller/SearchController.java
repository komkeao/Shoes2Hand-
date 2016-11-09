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

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductDB productDB = new ProductDB();
		ProductTypeDB db = new ProductTypeDB();
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		if (action.equals("search")) {

			int price = Integer.parseInt(request.getParameter("price"));
			String[] typeID = request.getParameterValues("type");

			ArrayList<Product> list = productDB.getProductListByTypeAndPrice(
					price, typeID);
			request.setAttribute("list", list);

			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			RequestDispatcher view = request.getRequestDispatcher("index"
					+ ".jsp");
			view.forward(request, response);

		} else if (action.equals("byType")) {

			int type = Integer.parseInt(request.getParameter("type"));
			ProductDB productDB1 = new ProductDB();
			ArrayList<Product> list = productDB1.getProductListByType(type);
			request.setAttribute("list", list);
			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			RequestDispatcher view = request.getRequestDispatcher("index"
					+ ".jsp");
			view.forward(request, response);

		} else if (action.equals("searchword")) {

			String str = request.getParameter("word");
			ProductDB productDB1 = new ProductDB();
			ArrayList<Product> list = productDB1.searchProduct(str);
			request.setAttribute("list", list);
			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			RequestDispatcher view = request.getRequestDispatcher("index"
					+ ".jsp");
			view.forward(request, response);
		}
	}
}
