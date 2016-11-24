package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Bill;
import model.BillDB;
import model.OrderList;
import model.OrderListDB;
import model.Product;
import model.ProductDB;

@WebServlet("/cart")
@MultipartConfig
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	boolean checkDupplicate(String str, String pid) {
		String[] c = str.split(",");
		boolean a = false;
		for (int i = 0; i < c.length; i++) {
			if (c[i].equals(pid)) {
				a = true;
			}
		}
		return a;
	}

	String delete(String str, String pid) {
		String[] c = str.split(",");
		String res = "";
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			if (!c[i].equals(pid)) {
				j++;
				if (j == 1) {

				} else {
					res += "," + c[i];
				}

			}
		}

		return res;
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		if (action.equals("addToBucket")) {
			Cookie[] cookies = null;
			// Get an array of Cookies associated with this domain
			cookies = request.getCookies();
			boolean flag = false;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					flag = true;
					if (!checkDupplicate(cookies[i].getValue(),
							request.getParameter("pid"))) {
						String old = cookies[i].getValue();
						old += "," + request.getParameter("pid");
						response.addCookie(new Cookie("cart", old));
					}
				}
			}
			if (!flag) {
				response.addCookie(new Cookie("cart", request
						.getParameter("pid")));
			}

			response.sendRedirect("cart");
		} else if (action.equals("delete")) {
			Cookie[] cookies = null;
			cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					delete(cookies[i].getValue(), request.getParameter("pid"));
					Cookie c = new Cookie("cart", delete(cookies[i].getValue(),
							request.getParameter("pid")));
					response.addCookie(c);
					response.sendRedirect("cart");
				}
			}
		} else if (action.equals("pay")) {
			HttpSession sess = request.getSession();
			if(!(sess.getAttribute("userId")==null)){
			BillDB bdb = new BillDB();
			Bill bill = new Bill();
			
			String bid = sess.getAttribute("userId").toString();
			bill.setUserID(Integer.parseInt(bid));
			bill.setSendAddress(new String(request.getParameter("address").getBytes("ISO8859_1"), "utf-8"));
			InputStream inputStream = null;
			Part filePart = request.getPart("photo");
			if (filePart != null) {
				inputStream = filePart.getInputStream();
			}

			bdb.add(bill, inputStream);
			int last = bdb.getLastIndex();
			OrderList ol = new OrderList();
			ol.setBid(last);
			Cookie[] cookies = null;
			// Get an array of Cookies associated with this domain
			cookies = request.getCookies();
			
			boolean flag = false;
			String[] c = null;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					flag = true;
					String tmp = cookies[i].getValue();
					c = tmp.split(",");
					cookies[i].setValue(null);
	                cookies[i].setMaxAge(0);
	                response.addCookie(cookies[i]);
				}
			}
			if (!flag) {
				// ว่างๆ

			} else {
				OrderListDB odb = new OrderListDB();
				ProductDB pdb=new ProductDB();
				for (int i = 0; i < c.length; i++) {
					if (!c[i].equals("")) {
						ol.setPid(Integer.parseInt(c[i]));
						odb.Insert(ol);
						pdb.updateStatusById(ol.getPid(), 1);
					}

				}
				
			}
			request.setAttribute("flag",1);
			RequestDispatcher view = request.getRequestDispatcher("cart"
					+ ".jsp");
			view.forward(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}

		} else {
			ProductDB pdb = new ProductDB();
			ArrayList<Product> list = new ArrayList<Product>();
			Cookie[] cookies = null;
			// Get an array of Cookies associated with this domain
			cookies = request.getCookies();
			boolean flag = false;
			String[] c = null;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					flag = true;
					String tmp = cookies[i].getValue();
					c = tmp.split(",");
				}
			}
			if (!flag) {
				// ว่างๆ
				request.setAttribute("list", null);
			} else {
				for (int i = 0; i < c.length; i++) {
					if (!c[i].equals("")) {
						Product a = pdb.getProductById(Integer.parseInt(c[i]));
						list.add(a);
					}

				}
				request.setAttribute("list", list);
			}

			RequestDispatcher view = request.getRequestDispatcher("cart"
					+ ".jsp");
			view.forward(request, response);

		}

	}
}
