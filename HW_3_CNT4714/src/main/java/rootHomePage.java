import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//import com.mysql.cj.jdbc.MysqlDataSource;
//import com.mysql.jdbc.Driver;

import java.sql.Statement;
import java.sql.ResultSet;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 




@SuppressWarnings("serial")
@WebServlet(name="rootHomePage", urlPatterns = {"/rootHomePage"})
public class rootHomePage extends HttpServlet {

	private Connection connection;
	//private Statement statement;
	
	@Override
	public void init() throws ServletException {
		
		try {
			//Driver?
			//Class.forName("com.mysql.cj.jdbc.MysqlDataSource");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
			
			//String URL = "jdbc:mysql://localhost:3306/HW_3_CNT4714"; //working?
			//String URL= "jdbc:mysql://localhost:3306/project3";
			String username = "root";
			String password = "Paconess1!";
			connection = DriverManager.getConnection(URL, username, password);
			
		} 
		
		catch (ClassNotFoundException e){
			
			System.out.println("Error");
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		  Properties properties = new Properties();
	       
	       FileInputStream filein1 = null;
	       
	       MysqlDataSource dataSource0 = null;
	    
       
		
		 //read properties file
	       try {
	    	   
	           filein1 = new FileInputStream("root.properties");

	           properties.load(filein1);
	           dataSource0 = new MysqlDataSource();
	           dataSource0.setURL(properties.getProperty("MYSQL_DB_URL"));
	           dataSource0.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
	           dataSource0.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
	       
	       } 
	       
	       catch (IOException e) {
	    	   
	           e.printStackTrace();
	           
	       }
	
	} 
	
	public void destroy() {
		
		try {
			
			connection.close();
			
		}
		
		catch (SQLException e) {
			
			System.out.println("Error");
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userInput = request.getParameter("userInput");
		String message = null;
		Statement statement = null; //?
		connection = null; //?
	/*	String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
		//String URL= "jdbc:mysql://localhost:3306/project3";
		//String URL= "jdbc:mysql://localhost:3306/project2";
		String username = "root";
		String password = "Paconess1!"; */
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.MysqlDatasource");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {//(Connection connection = DriverManager.getConnection()) {
		//try (Connection connection = DriverManager.getConnection(URL, username, password)){
			
			
		/*	String URL= "jdbc:mysql://localhost:3306/project3";
			//String URL = "jdbc:mysql://localhost:3306/project3?useTimezone=true&serverTimezone=UTC";
			String username = "root";
			String password = "Paconess1!"; */
		//	Connection connection = DriverManager.getConnection(URL, username,password);
			
			
			//String URL= "jdbc:mysql://localhost:3306/project3";
			//String URL= "jdbc:mysql://localhost:3306/project2";
			
		
		//	statement = connection.createStatement();
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.MysqlDatasource");
			
	
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("Paconess1!");
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
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/rootHome.jsp");
		dispatcher.forward(request, response);   
		
	/*	String rootHomePage = "/rootHomePage.jsp";
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(rootHomePage);
		dispatcher1.forward(request, response); //? */
		
	}   

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		doGet(request, response);
		
	}
}
