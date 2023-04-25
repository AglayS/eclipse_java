import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import com.mysql.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Properties;

import java.sql.Statement;
import java.sql.ResultSet;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 


//@SuppressWarnings("serial")
@WebServlet(name="clientHomePage", urlPatterns = {"/clientHomePage"})
public class clientHomePage extends HttpServlet {

	private Connection connection;
	
	@Override
	public void init() throws ServletException {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
			//String URL= "jdbc:mysql://localhost:3306/project3";
			String username = "client";
			String password = "client";
			connection = DriverManager.getConnection(URL, username, password);
			
		} 
		
		catch(ClassNotFoundException e){
			
			System.out.println("Error");
			
		} 
		
		catch (SQLException e) {
		
			e.printStackTrace();
			
		}
	} 
	
	public void destroy() {
		
		try {
			
			connection.close();
			
		}
		
		catch(SQLException e) {
			
			System.out.println("Error");
			
		}
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userInput = request.getParameter("userInput");
		String message = null;
		Statement statement = null; //?
		connection = null; //?
		
	/*	String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
		//String URL= "jdbc:mysql://localhost:3306/project3";
		String username = "client";
		String password = "client";
		*/
		
		
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.MysqlDatasource");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		try {//(Connection connection = DriverManager.getConnection(URL, username, password)) {
			
			
		
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.MysqlDatasource");
	
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("client");
			dataSource.setPassword("client");
			dataSource.setUrl("jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC");
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			userInput = userInput.trim();
			String Type = userInput.substring(0, 6);
			
			if (Type.equalsIgnoreCase("select")) {
				
				ResultSet resultSet = statement.executeQuery(userInput);
				message = arrange.getHtmlRows(resultSet);
			
			}
			
			else {
				
				statement.close();
				
			}
		}
		
		
		catch (SQLException e) {
			
			message = "<p style=\"text-align:center;\">Error executing Statement</p>" + "<p style=\"text-align:center;\">"+ e.getMessage() +"</p>";
			System.out.println("Error");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		HttpSession session = request.getSession();
		session.setAttribute("message",  message);;
		session.setAttribute("userInput", userInput);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clientHomePage.jsp");
		dispatcher.forward (request, response);
		
	/*	String clientHomePage = "/clientHomePage.jsp";
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(clientHomePage);
		dispatcher1.forward(request, response); //? */
	
	}  

	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		
		doGet(request, response);
	
	}

}