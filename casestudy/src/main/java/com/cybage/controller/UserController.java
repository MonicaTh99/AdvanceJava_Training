package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.User;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

public class UserController extends HttpServlet {

	private UserDao userDao = new UserDaoImpl();

	// private UserDao userDao = new BetterUserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		System.out.println("inside usercontroller");

		String path = request.getPathInfo();
		if (path.equals("/add")) {
			System.out.println("inside add method....");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			User user = new User(username, password, address);
			try {
				int addCount = userService.addUer(user);
				System.out.println("number of record added.." + addCount);
				if (addCount > 0) {
					response.sendRedirect("list");
				}

			} catch (Exception e) {
				System.out.println("exception occurred... " + e.getLocalizedMessage());
			}
		}
		if (path.equals("/list")) {
			System.out.println("inside list method....");
			try {
				List<User> users = userService.findUser();
				request.setAttribute("users", users);

				request.getRequestDispatcher("/user/view-user.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		if (path.equals("/delete")) {
			System.out.println("inside delete method....");
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				int deleteCount = userService.deleteUser(id);

				response.sendRedirect("list");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		if (path.equals("/edit")) {
			System.out.println("inside edit method....");
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				User user = userService.findUserById(id);
				request.setAttribute("user", user);

				request.getRequestDispatcher("/user/edit-user.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
//		actual updation happens here...
		if (path.equals("/edit-user")) {
			System.out.println("inside edit-user method....");
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			User user = new User(id, username, password, address);
			try {
				userService.udpateUser(user);
				response.sendRedirect("list");

			} catch (Exception e) {
				System.out.println("exception occurred... " + e.getLocalizedMessage());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}