package com.avensys.studentracker;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;
	@Resource(name = "jdbc/studentdb")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		try {
			// Create our studentDbUtil and pass it to connection pool
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Listing students in MVC design pattern
		try {
			// Read command parameter from add_student_form.jsp
			String command = request.getParameter("command");
			if(command == null) {
				command = "list";
			}
			// Route to an appropriate method
			switch (command) {
			case "list":
				listStudents(request, response);
				break;
			case "add":
				addStudent(request, response);
				break;
			case "updateDetails" :
				displayStudentDetails(request, response);
				break;
			case "update":
				updateStudent(request, response);
				break;
			case "delete":
				deleteStudent(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void displayStudentDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. Read studentId from the form data
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 2. Get student details from DB
		Student student = studentDbUtil.getStudent(id);
		
		// 3. Place student in request attribute
		request.setAttribute("student", student);
		
		// 4. Send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update_student_form.jsp");
		dispatcher.forward(request, response);
		
		/*
		 * int id = Integer.parseInt(request.getParameter("id")); Student student =
		 * studentDbUtil.getStudent(id); request.setAttribute("student", student);
		 * 
		 * // Get RequestDispatcher, forward to JSP RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/update_student_form.jsp");
		 * dispatcher.forward(request, response);
		 */

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Get add student form parameters
		int id = Integer.parseInt(request.getParameter("id"));
		studentDbUtil.deleteStudent(id);
		// Add student to DB
		try {
			studentDbUtil.deleteStudent(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listStudents(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Get add student form parameters
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		// Create new student with the parameters
		Student student = new Student(id, firstName, lastName, email);

		// Add student to DB
		try {
			studentDbUtil.updateStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listStudents(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Get add student form parameters
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		// Create new student with the parameters
		Student student = new Student(firstName, lastName, email);

		// Add student to DB
		try {
			studentDbUtil.addStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listStudents(request, response);
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Get students from StudentDbUtil, set to request
		List<Student> students = studentDbUtil.getStudents();
		request.setAttribute("STUDENT_LIST", students);

		// Get RequestDispatcher, forward to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_students.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
