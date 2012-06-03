package servlets;



import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gcasillascos
 */
public class ConexionCliGols {

        public static Connection getConnection() throws Exception {
    // load the Oracle JDBC Driver
    Class.forName("com.mysql.jdbc.Driver");
    // define database connection parameters
    return DriverManager.getConnection ("jdbc:mysql://localhost:3306/meta","root", "lala");
  }


  public static ArrayList<Point> getClis() throws Exception {



    Connection conn = null; // connection object
    Statement stmt = null; // statement object
    ResultSet rs = null; // result set object
    try {
      conn = getConnection(); // without Connection, can not do much
      // create a statement: This object will be used for executing
      // a static SQL statement and returning the results it produces.
      stmt = conn.createStatement();
      // start a transaction


      // get all of the the records from the cats_tricks table
      rs = stmt.executeQuery("SELECT cli_gol_id,cli_id  FROM CLI_GOL");

      // iterate the result set and get one row at a time

      ArrayList<Point> a = new ArrayList<Point>();
      while (rs.next()) {

        int idGol = rs.getInt(1); // 1st column in query
        int idCli = rs.getInt(2); // 2nd column in query

        a.add(new Point(idGol, idCli));
          
      }
      return a;
    }     catch (SQLException e) {
      // something went wrong, we are handling the exception here


      System.out.println("--- SQLException caught ---");
      // iterate and get all of the errors as much as possible.
      while (e != null) {
        System.out.println("Message   : " + e.getMessage());
        System.out.println("SQLState  : " + e.getSQLState());
        System.out.println("ErrorCode : " + e.getErrorCode());
        System.out.println("---");
        e = e.getNextException();
      }


    } finally { // close db resources
      try {
        rs.close();
        stmt.close();
        conn.close();
      } catch (Exception e) {
      }

    }

return null;
  }

  public static void main(String[] args) throws SQLException, Exception {

       

        ConexionCliGols.getConnection();
  }



}
