package com.fssa.leavemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.leavemanagement.exceptions.DAOException;
import com.fssa.leavemanagement.model.Employee;
import com.fssa.leavemanagement.service.EmployeeService;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

//		Employee employee = new Employee("pranaw", "pranaw@gmail.com", "IFresh100%", LocalDate.of(2023, 07, 27), true,
//				null, null);

//		out.println(employee);

		try {
			List<Employee> arr = EmployeeService.getAllEmployee();
			for (Employee employee : arr) {
				System.out.println("Name: " + employee.getName() + ", Email: " + employee.getEmail());
			}
		} catch (DAOException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
