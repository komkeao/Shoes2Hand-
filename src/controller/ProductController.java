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
		ProductTypeDB db = new ProductTypeDB();
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

		} else if (action.equals("addType")) {
			ProductType productType = new ProductType();
			productType.setTypeName(new String(request.getParameter("typeName")
					.getBytes("ISO8859_1"), "utf-8"));
			db.insert(productType);

			response.sendRedirect("product?action=add");
		} else if (action.equals("add")) {

			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			RequestDispatcher view = request
					.getRequestDispatcher("productAdd.jsp");
			view.forward(request, response);

		} else if (action.equals("edit")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			Product product = productDB.getProductById(pid);
			ArrayList<ProductType> productType = db.getListType();
			request.setAttribute("productType", productType);
			request.setAttribute("product", product);
			RequestDispatcher view = request
					.getRequestDispatcher("productEdit.jsp");
			view.forward(request, response);

		} else if (action.equals("edited")) {
			Product product = new Product();

			product.setDescription(new String(request.getParameter(
					"description").getBytes("ISO8859_1"), "utf-8"));
			product.setpName(new String(request.getParameter("name").getBytes(
					"ISO8859_1"), "utf-8"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setStatus(0);
			product.setPid(Integer.parseInt(request.getParameter("pid")));
			product.setTypeID(Integer.parseInt(request.getParameter("type")));
			productDB.update(product);
			response.sendRedirect("./");
		} else if (action.equals("delete")) {
			productDB.removeProductById(Integer.parseInt(request
					.getParameter("pid")));
			response.sendRedirect("./");
		}

	}

}
