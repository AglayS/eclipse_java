import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Properties;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Properties;

@SuppressWarnings("serial")
@WebServlet(name="clientHomePage", urlPatterns = {"/clientHomePage"})
public class clientHomePage extends HttpServlet {

	private Connection connection;
	
	@Override
	public void init() throws ServletException {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
			String URL= "jdbc:mysql://localhost:3306/project3";
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
		
		String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
		//String URL= "jdbc:mysql://localhost:3306/project3";
		String username = "client";
		String password = "client";
		
		try (Connection connection = DriverManager.getConnection(URL, username, password)) {
			
			//Statement statement= connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			Statement statement = connection.createStatement();
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
		
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message",  message);;
		session.setAttribute("userInput",userInput);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clientHomePage.jsp");
		dispatcher.forward(request, response);
		
	/*	String clientHomePage = "/clientHomePage.jsp";
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(clientHomePage);
		dispatcher1.forward(request, response); //? */
	
	}  

	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		
		doGet(request, response);
	
	}

}