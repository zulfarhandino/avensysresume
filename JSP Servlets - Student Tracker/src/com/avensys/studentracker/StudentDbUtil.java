package com.avensys.studentracker;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class StudentDbUtil {

	@Resource(name = "jdbc/studentdb")
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rst = null;

		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			String query = "SELECT * FROM studentdb.student ORDER BY firstName;";
			stmt = con.createStatement();
			rst = stmt.executeQuery(query);
			// Process result set
			while (rst.next()) {
				// Retrieve data from result set
				int id = rst.getInt("id");
				String firstName = rst.getString("firstName");
				String lastName = rst.getString("lastName");
				String email = rst.getString("email");
				// Create new objects
				Student student = new Student(id, firstName, lastName, email);
				// Add to list
				students.add(student);
			}
			return students;
		} finally {
			// Close JDBC connection
			close(con, stmt, rst);
		}
	}

	private void close(Connection con, Statement stmt, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			stmt = con.prepareStatement("INSERT INTO studentdb.student (firstName, lastName, email) VALUES(?,?,?)");
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.executeUpdate();
		} finally {
			close(con, stmt, rst);
		}
	}

	public Student getStudent(int id) throws Exception {

		Student student;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;

		try {
			// Connect to DB
			con = dataSource.getConnection();

			// Create SQL statement
			String query = "SELECT * FROM studentdb.student WHERE id=?";

			// Create prepared statement
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);

			// Execute query
			rst = pstmt.executeQuery();

			// Return student
			if (rst.next()) {
				String firstName = rst.getString("firstName");
				String lastName = rst.getString("lastName");
				String email = rst.getString("email");
				student = new Student(id, firstName, lastName, email);
				return student;
			} else {
				return null;
			}
		} finally {
			// Close JDBC
			close(con, pstmt, rst);
		}
		/*
		 * Student student = null; Connection con = null; Statement stmt = null;
		 * ResultSet rst = null;
		 * 
		 * try { // Connect to DB con = dataSource.getConnection(); // Create query and
		 * execute query String query = "SELECT * FROM studentdb.student WHERE id = " +
		 * id + ";"; stmt = con.createStatement(); rst = stmt.executeQuery(query); //
		 * Process result set // Retrieve data from result set while (rst.next()) {
		 * String firstName = rst.getString("firstName"); String lastName =
		 * rst.getString("lastName"); String email = rst.getString("email"); // Create
		 * new objects student = new Student(id, firstName, lastName, email); } return
		 * student; } finally { // Close JDBC connection close(con, stmt, rst); }
		 */
	}

	public void updateStudent(Student student) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rst = null;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			String query = String.format(
					"UPDATE studentdb.student SET firstName = '%s', lastName = '%s', email = '%s' WHERE id = '%d'",
					student.getFirstName(), student.getLastName(), student.getEmail(), student.getId());
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} finally {
			// Close JDBC connection
			close(con, stmt, rst);
		}
	}

	public void deleteStudent(int id) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rst = null;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			String query = "DELETE FROM studentdb.student WHERE id = " + id + ";";
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} finally {
			// Close JDBC connection
			close(con, stmt, rst);
		}
	}
	
}
