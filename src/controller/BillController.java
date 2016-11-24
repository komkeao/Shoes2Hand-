package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import model.BillDetails;
import model.BillDetailsDB;

@WebServlet("/bill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BillDetailsDB bdb = new BillDetailsDB();
		ArrayList<BillDetails> list =new ArrayList<BillDetails>();
		list=bdb.getBillList();
		request.setAttribute("list",list);
		RequestDispatcher view = request.getRequestDispatcher("billCheck"
				+ ".jsp");
		view.forward(request, response);
	}

}
