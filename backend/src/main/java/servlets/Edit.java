package servlets;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;


@WebServlet("/Edit")
public class Edit extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }
    static String url ="jdbc:mysql://localhost:3306/grey_goose";
    static String user = "root";
    static  String pass ="India@123";

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
    String p1=request.getParameter("sl_no");
    String p2=request.getParameter("invoice_currency");
    String p3=request.getParameter("cust_payment_terms");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection con = null;
      
      con = DriverManager.getConnection(url,user,pass);
      
      String Query="UPDATE winter_internship SET invoice_currency ='"+ p2 +"',cust_payment_terms ='"+ p3 +"' WHERE sl_no='"+p1+"'";
      Statement st = con.createStatement();
      st.executeUpdate(Query);
      
      System.out.println(Query);
    }catch(SQLException | ClassNotFoundException e){
      e.printStackTrace();
    }
  }

 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
       doGet(request,response);
  }

}