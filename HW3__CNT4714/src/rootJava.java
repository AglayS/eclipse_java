import jakarta.servlet.*;
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

import com.mysql.cj.jdbc.MysqlDataSource;


public class rootJava extends HttpServlet {

	private Connection connection;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL= "jdbc:mysql://localhost:3306/project4";
			String username = "root";
			String password = "#Fixer123";
			connection = DriverManager.getConnection(URL, username, password);
		} catch(ClassNotFoundException e){
			System.out.println("Error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			connection.close();
		}catch(SQLException e) {
			System.out.println("Error");
		}
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		String userInput = request.getParameter("userInput");
		String message = null;
		String logicStatement ="update suppliers set status = status + 5 where snum in (select snum from shipments where quantity >= 100);";
		try {
			Statement statement = connection.createStatement();
			userInput = userInput.trim();
			String Type = userInput.substring(0, 6);
			if(Type.equalsIgnoreCase("select")) {
				ResultSet resultSet = statement.executeQuery(userInput);
				message = arrangement.getHtmlRows(resultSet);
			}else {
				int i = statement.executeUpdate(userInput);
				if(i == 0) {
					message = "<p style=\"text-align:center;\">The statement has executed Successfully</p>"
							+ "<p style=\"text-align:center;\">"+ i +" row(s) affected</p>";
				}else {
					int q = statement.executeUpdate(logicStatement);
					message = "<p style=\"text-align:center;\">The statement has executed Successfully</p>"
							+ "<p style=\"text-align:center;\">"+ i +" row(s) affected</p>"
							+ "<p style=\"text-align:center;\">Business logic Detected: - Updating Supplier Status...</p>"
							+ "<p style=\"text-align:center;\">Logic Updated "+ q +" suppliers marks</p>";
				}
				statement.close();
			}
		}catch(SQLException e) {
			message = "<p style=\"text-align:center;\">Error executing Statement</p>"
					+ "<p style=\"text-align:center;\">"+ e.getMessage() +"</p>";
			System.out.println("Error");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message",  message);;
		session.setAttribute("userInput",userInput);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/root.jsp");
		dispatcher.forward(request, response);      
	}   

	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		doGet(request, response);
	}
