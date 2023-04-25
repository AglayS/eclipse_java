import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.ResultSetMetaData;

public class arrange {
	
	public static synchronized String getHtmlRows (ResultSet results) throws SQLException{
		
		StringBuffer htmlRows = new StringBuffer();
		
		ResultSetMetaData metaData = results.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		
		htmlRows.append("<tr bgcolor=red align=center>");
		
		for(int i = 1 ; i <= columnCount ; i++) {
			
			htmlRows.append("<td><b>" + metaData.getColumnName(i) + "</td>");
			
		}
		
		htmlRows.append("</tr>");
		
		int cnt = 0;
		
		while (results.next()) {
			
			if(cnt % 2 == 0) {
				
				htmlRows.append("<tr bgcolor=white>");
				
			}
			
			else {
				
				htmlRows.append("<tr bgcolor=#dedede>");
				
			}
			
			cnt++;
			
			for (int i = 1 ; i <= columnCount ; i++) {
				
				htmlRows.append("<td align=center>" + results.getString(i) + "</td>");
				
			}
		}
		
		htmlRows.append("</tr>");
		String s = htmlRows.toString();
		return s;
		
	}
}
