/* 
  Name: Aglay Saenz
  Course: CNT 4714 Summer 2022 
  Assignment title: Project 2 – A Two-tier Client-Server Application 
  Date:  June 26, 2022 
 
  Class:  CNT4714
*/


package HW2;



import com.mysql.cj.jdbc.MysqlDataSource;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;


public class GUI extends JFrame { 



   private JLabel jlbDriver;
   private JLabel jlbDataBaseURL;
   private JLabel jlbUsername;
   private JLabel jlbPassword;
   private JLabel jlbConnectionStatus;
   private JComboBox driverList;
   private JComboBox dataBaseURLList;
   private JTextField jtfUsername;
   private JPasswordField jpfPassword;
   private JTextArea jtaSqlCommand;
   private JButton jbtConnectToDB;
   private JButton jbtClearSQLCommand;
   private JButton jbtExecuteSQLCommand;
   private JButton jbtClearResultWindow;
   private ResultSetTableModel tableModel = null;
   private JTable table;

   private Connection connection;
   
   // keep track of database connection status
   private boolean connectedToDatabase = false;

public GUI() throws ClassNotFoundException, SQLException, IOException {
   
       //GUI components
       this.createInstanceGUIComponents();

       Properties properties = new Properties();
       
       FileInputStream filein1 = null;
   //    FileInputStream filein1 = new FileInputStream("root.properties");
       
       FileInputStream filein2 = null;
       MysqlDataSource dataSource0 = null;
     //  MysqlDataSource dataSource0 = new MysqlDataSource();
       
       MysqlDataSource dataSource1 = null;
    //   MysqlDataSource dataSource1 = new MysqlDataSource();

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

       try {
    	   
           filein2 = new FileInputStream("client.properties");
    	   
           properties.load(filein2);
           dataSource1 = new MysqlDataSource();
           dataSource1.setURL(properties.getProperty("MYSQL_DB_URL"));
           dataSource1.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
           dataSource1.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
           
       } 
       
       catch (IOException e) {
    	   
           e.printStackTrace();
           
       }

       //action for connect to DB button
       MysqlDataSource finalDataSource0 = dataSource0;
       MysqlDataSource finalDataSource1 = dataSource1;
       
       this.jbtConnectToDB.addActionListener (new ActionListener() {
       

      
		@Override
           public void actionPerformed (ActionEvent arg0) {
           

               try {
               
                   Class.forName(String.valueOf(driverList.getSelectedItem()));
                   
                 //  Class.forName("com.mysql.jdbc.MysqlDataSource");
            	  // Class.forName("com.mysql.jdbc.Driver");
                   
               } 
               
               catch (ClassNotFoundException e) {
               
                   //update connection status
                   jlbConnectionStatus.setText("No Connection Now");
                   jlbConnectionStatus.setForeground(Color.RED);
                   e.printStackTrace();
                 
                   //clear the table
                   table.setModel(new DefaultTableModel());
                   tableModel = null; 
                   
               }

               //establish connection to DB
               try {
               
                   //disconnect
                   if (connectedToDatabase == true) {
                   
                       connection.close();
                       
                       //change status
                       jlbConnectionStatus.setText("No Connection Now");
                       jlbConnectionStatus.setForeground(Color.RED);
                       
                       //update connection status
                       connectedToDatabase = false;
                       
                       //clear the table
                       table.setModel(new DefaultTableModel());
                       tableModel = null;
                       
                   }

                //   connection = DriverManager.getConnection(String.valueOf(dataBaseURLList.getSelectedItem()), jtfUsername.getText(), jpfPassword.getText());
                  
                 //  if (driverList.getSelectedItem() == "db.properties") {
                   if (driverList.getSelectedItem() == "root.properties") {
                	   
                       connection = finalDataSource0.getConnection("jdbc:mysql://localhost:3306/project2?useTimezone=true&serverTimezone=UTC", "root", "rootMAC1$");
                       
                   }

                   else {
                	   
                       connection = finalDataSource1.getConnection("jdbc:mysql://localhost:3306/project2?useTimezone=true&serverTimezone=UTC", "client", "client");
                       
                   }
                   
                   //change status
                   jlbConnectionStatus.setText("Connected to " + String.valueOf(dataBaseURLList.getSelectedItem()));
                   jlbConnectionStatus.setForeground(Color.GREEN);
                   
                   //update connection status
                   connectedToDatabase = true;
               
               } 
               
               catch (SQLException e) {
               
                   //update status
                   jlbConnectionStatus.setText("No Connection Now");
                   jlbConnectionStatus.setForeground(Color.RED);
                   //clear the table
                   table.setModel(new DefaultTableModel());
                   tableModel = null;
                   e.printStackTrace();
                   
               }

           }

       });


       //clear sql text area
       this.jbtClearSQLCommand.addActionListener (new ActionListener() {
       

           @Override
           public void actionPerformed (ActionEvent arg0) {
           
               jtaSqlCommand.setText("");
               
           }

       });

       //execute and update database
       this.jbtExecuteSQLCommand.addActionListener (new ActionListener() {
       

           @Override
           public void actionPerformed (ActionEvent arg0) {
           

               //make new table if we have not made one before
               if ((connectedToDatabase == true) && (tableModel == null)) {
               
                   try {
                   
                       tableModel = new ResultSetTableModel(jtaSqlCommand.getText(), connection);
                       
                       table.setModel(tableModel);
                       
                   } 
                   
                   catch (ClassNotFoundException | SQLException | IOException e) {
                   
                       //clear table
                       table.setModel(new DefaultTableModel());
                       tableModel = null;
                       
                       //display warning
                       JOptionPane.showMessageDialog( null, e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );
                       e.printStackTrace();
                       
                   }
               }
               
               else
                   //have abstract table model has been create execute string
            	   
                   if (connectedToDatabase == true && tableModel != null) {
                   
                       //determine if we are executing a an update or query
                       String query = jtaSqlCommand.getText();
                       
                       if (query.contains("select") || query.contains("SELECT")) {
                       
                           try {
                           
                               tableModel.setQuery(query);
                               
                           } 
                           
                           catch (IllegalStateException | SQLException e) {
                           
                               
                               table.setModel(new DefaultTableModel());
                               
                               tableModel = null;
                               
                               //display warning
                               JOptionPane.showMessageDialog( null, e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );

                               e.printStackTrace();
                               
                           }
                       }
                       
                       else {
                       
                           try {
                           
                               tableModel.setUpdate(query);
                            
                               table.setModel(new DefaultTableModel());
                               tableModel = null;
                               
                           } 
                           
                           catch (IllegalStateException | SQLException e) {
                           
                          
                               table.setModel(new DefaultTableModel());
                               tableModel = null;
                             
                               JOptionPane.showMessageDialog( null, e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );

                               e.printStackTrace();
                               
                           }
                       }
                   }
               
           }

       });

       //clear table
       this.jbtClearResultWindow.addActionListener (new ActionListener() {
       

           @Override
           public void actionPerformed (ActionEvent arg0) {
           
               //update number of rows to zero
               table.setModel(new DefaultTableModel());
               tableModel = null;

           }

       });

       //button
       JPanel buttons = new JPanel(new GridLayout(1, 4));
       buttons.add(this.jlbConnectionStatus);
       buttons.add(this.jbtConnectToDB);
       buttons.add(this.jbtClearSQLCommand);
       buttons.add(this.jbtExecuteSQLCommand);

       //panel
       JPanel labelsAndTextFields = new JPanel(new GridLayout(4, 2));
       labelsAndTextFields.add(this.jlbDriver);
       labelsAndTextFields.add(this.driverList);
       labelsAndTextFields.add(this.jlbDataBaseURL);
       labelsAndTextFields.add(this.dataBaseURLList);
       labelsAndTextFields.add(this.jlbUsername);
       labelsAndTextFields.add(this.jtfUsername);
       labelsAndTextFields.add(this.jlbPassword);
       labelsAndTextFields.add(this.jpfPassword);


       //top of gui
       JPanel top = new JPanel(new GridLayout(1, 2));
       top.add(labelsAndTextFields);
       top.add(this.jtaSqlCommand);

       //table, button
       JPanel south = new JPanel();
       south.setLayout(new BorderLayout(20,0));
       south.add(new JScrollPane(this.table), BorderLayout.NORTH);
       south.add(this.jbtClearResultWindow, BorderLayout.SOUTH);

       //panelling
       add(top, BorderLayout.NORTH);
       add(buttons, BorderLayout.CENTER);
       add(south, BorderLayout.SOUTH);


       //dispose window
       setDefaultCloseOperation ( DISPOSE_ON_CLOSE );

       //close database connection when user quits
       addWindowListener (new WindowAdapter() {
       
           // disconnect and close window when done
           public void windowClosed ( WindowEvent event ) {
           
               try {
               
                   //close connection on frame exit
                   if (!connection.isClosed()) {
                	   
                       connection.close();
                       
                   }
                   
               } 
               
               catch (SQLException e) {
       
                   e.printStackTrace();
                   
               }
               
               System.exit( 0 );
               
           } 
           
       });

   }


public void createInstanceGUIComponents() throws ClassNotFoundException, SQLException, IOException {
	   
	   
       String[] propertiesString = { "client.properties", "root.properties" };
       String[] dataBaseURLString = { "jdbc:mysql://localhost:3306/project2?useTimezone=true&serverTimezone=UTC", "" };


       // handle JLabel

       this.jlbDriver = new JLabel("Properties File");
       this.jlbDataBaseURL = new JLabel("Database URL");
       this.jlbUsername = new JLabel("Username");
       this.jlbPassword = new JLabel("Password");
       this.jlbConnectionStatus = new JLabel("No Connection Now");
       this.jlbConnectionStatus.setForeground(Color.RED);

       //combo boxes
       this.driverList = new JComboBox<Object>(propertiesString);
       this.driverList.setSelectedIndex(0);
       this.dataBaseURLList = new JComboBox<Object>(dataBaseURLString);

       //text fields
       this.jtfUsername = new JTextField();
       this.jpfPassword = new JPasswordField();

       //jtextarea
       this.jtaSqlCommand = new JTextArea(3, 75);
       this.jtaSqlCommand.setWrapStyleWord(true);
       this.jtaSqlCommand.setLineWrap(true);

       //buttons
       this.jbtConnectToDB = new JButton("Connect to Database");
       this.jbtClearSQLCommand = new JButton("Clear SQL Command");
       this.jbtExecuteSQLCommand = new JButton("Execute SQL Command");
       this.jbtClearResultWindow = new JButton("Clear Result Window");

       //table
       this.table = new JTable();
   }

}

class Driver {
	
   public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	   
       GUI myFrame = new GUI();
       myFrame.setVisible(true);
       myFrame.pack();
       myFrame.setLayout(new BorderLayout(2,0));
       
   }
}

//ResultSet rows and columns are counted from 1 and JTable
//rows and columns are counted from 0. When processing
//ResultSet rows or columns for use in a JTable, it is
//necessary to add 1 to the row or column number to manipulate
//the appropriate ResultSet column (i.e., JTable column 0 is
//ResultSet column 1 and JTable row 0 is ResultSet row 1).
class ResultSetTableModel extends AbstractTableModel {
	
   private Connection connection;
   private Statement statement;
   private ResultSet resultSet;
   private ResultSetMetaData metaData;
   private int numberOfRows;

   // keep track of database connection status
   private boolean connectedToDatabase = false;

   // constructor passes in connection and query string
   // determines number of rows
   public ResultSetTableModel ( String query , Connection connection) throws SQLException, ClassNotFoundException, IOException {
   
       //read properties file
       try {

           // check connection status
           this.connection = connection;
           
           if (!this.connection.isClosed()) {
           
               connectedToDatabase = true;

               // create Statement to query database
               statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

               if (query.contains("select") || query.contains("SELECT")) {
               
                   try {
                   
                       setQuery(query);
                       
                   } 
                   
                   catch (IllegalStateException | SQLException e) {
                   
                       JOptionPane.showMessageDialog ( null, e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );
                       
                       e.printStackTrace();
                       
                   }
               }
               
               else {
               
                   try {
                   
                       setUpdate(query);
                       
                   } 
                   
                   catch (IllegalStateException | SQLException e) {
                   
                       JOptionPane.showMessageDialog( null, e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );
                       
                       e.printStackTrace();
                       
                   }
                   
               }

           }

           //check to see if we are doing setupdate or set query

           //set update and execute it
           //setUpdate (query);
       } //end try
       
       catch ( SQLException sqlException ) {
       
           sqlException.printStackTrace();
           
           System.exit( 1 );
           
       } // end catch
       
   } // end constructor ResultSetTableModel


// get class that represents column type
public Class getColumnClass( int column ) throws IllegalStateException {
	   
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }
       

       try {
       
           String className = metaData.getColumnClassName( column + 1 );

           // return Class object that represents className
           return Class.forName( className );
           
       } 
       
       catch ( Exception exception ) {
       
           exception.printStackTrace();
           
       } 

       return Object.class; // if problems occur above, assume type Object
       
   } // end method getColumnClass

   // get number of columns in ResultSet
   public int getColumnCount() throws IllegalStateException {
   
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }

       // determine number of columns
       try {
       
           return metaData.getColumnCount();
           
       } 
       
       catch ( SQLException sqlException ) {
       
           sqlException.printStackTrace();
           
       } 

       return 0; // if problems occur above, return 0 for number of columns
       
   } // end method getColumnCount

   // get name of a particular column in ResultSet
   public String getColumnName( int column ) throws IllegalStateException {
	   
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }
       // determine column name
       try {
    	   
           return metaData.getColumnName( column + 1 );
           
       } 
       
       catch ( SQLException sqlException ) {
    	   
           sqlException.printStackTrace();
           
       } 

       return ""; // if problems, return empty string for column name
       
   } // end method getColumnName

   // return number of rows in ResultSet
   public int getRowCount() throws IllegalStateException {
	   
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }

       return numberOfRows;
       
   } // end method getRowCount

   // obtain value in particular row and column
   public Object getValueAt( int row, int column ) throws IllegalStateException {
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }
       
       // obtain a value at specified ResultSet row and column
       try {
       
           resultSet.next();  /* fixes a bug in MySQL/Java with date format */
           
           resultSet.absolute( row + 1 );
           
           return resultSet.getObject( column + 1 );
           
       } 
       
       catch ( SQLException sqlException ) {
       
           sqlException.printStackTrace();
           
       } 

       return ""; // if problems, return empty string object
       
   } // end method getValueAt

   // set new database query string
   public void setQuery( String query ) throws SQLException, IllegalStateException {
	   
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
       
       }
       // specify query and execute it
       resultSet = statement.executeQuery( query );

       // obtain meta data for ResultSet
       metaData = resultSet.getMetaData();

       // determine number of rows in ResultSet
       resultSet.last();                   // move to last row
       numberOfRows = resultSet.getRow();  // get row number

       // notify JTable that model has changed
       fireTableStructureChanged();
       
   } // end method setQuery


   // set new database update-query string
   public void setUpdate( String query ) throws SQLException, IllegalStateException {
	   
      // int res;
       // ensure database connection is available
       if ( !connectedToDatabase ) {
    	   
           throw new IllegalStateException( "Not Connected to Database" );
           
       }
       // specify query and execute it
      int res = statement.executeUpdate( query );
       
/*
     // obtain meta data for ResultSet
     metaData = resultSet.getMetaData();
     // determine number of rows in ResultSet
     resultSet.last();                   // move to last row
     numberOfRows = resultSet.getRow();  // get row number
*/
       
       // notify JTable that model has changed
       fireTableStructureChanged();
   } // end method setUpdate

}  // end class ResultSetTableModel

//MYSQL_DB_URL=jdbc:mysql//localhost:3306/bikeb?useTimezone=true&serverTimezone=UTC
	