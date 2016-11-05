package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDB;
@WebServlet("/account")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		UserDB userDB = new UserDB();
		
		if (action.equals("register")) {
			
			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			
			if (cpassword.equals(password)) {
				
				User user = new User();
				user.setType(0);
				user.setSsn(request.getParameter("ssn"));
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setUsername(new String(request.getParameter("username")
						.getBytes("ISO8859_1"), "utf-8"));
				user.setAddress(new String(request.getParameter("address")
						.getBytes("ISO8859_1"), "utf-8"));
				userDB.register(user);
			}
			
			HttpSession sess = request.getSession();
			sess.setAttribute("name", new String(request.getParameter("username").getBytes(
					"ISO8859_1"), "utf-8"));
			request.setAttribute(
					"username",
					new String(request.getParameter("username").getBytes(
							"ISO8859_1"), "utf-8"));
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute(
					"address",
					new String(request.getParameter("address").getBytes(
							"ISO8859_1"), "utf-8"));
			request.setAttribute("text", "ลงทะเบียนเสร็จสิ้น!!");
			RequestDispatcher view = request.getRequestDispatcher("result"
					+ ".jsp");
			view.forward(request, response);
			
		} else if (action.equals("logout")) {
			
			HttpSession sess = request.getSession();
			sess.setAttribute("name", null);
			sess.invalidate();
			RequestDispatcher login = request
					.getRequestDispatcher("login.jsp");
			request.setAttribute("Auth", "logout");
			login.forward(request, response);

		} else {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = userDB.login(email, password);
			if (user.getUserID() == 0) {
				
				RequestDispatcher login = request
						.getRequestDispatcher("login.jsp");
				request.setAttribute("Auth", "error");
				login.forward(request, response);

			} else {
				HttpSession sess = request.getSession();
				sess.setAttribute("name", user.getUsername());
				request.setAttribute("username", user.getUsername());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("address", user.getAddress());
				request.setAttribute("text", "ยินดีต้อนรับ!!");
				RequestDispatcher view = request.getRequestDispatcher("result"
						+ ".jsp");
				view.forward(request, response);

			}

		}
	}

}
