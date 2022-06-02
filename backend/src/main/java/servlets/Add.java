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
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class insert_Servlet
 */

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add() {
		super();
		// TODO Auto-generated constructor stub
	}

	static String url = "jdbc:mysql://localhost:3306/grey_goose";
	static String user = "root";
	static String pass = "India@123";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = null;
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			String v1 = request.getParameter("business_code"); // business_code
			String v2 = request.getParameter("cust_number"); // cust_number
			String v3 = request.getParameter("clear_date"); // clear_date
			String v4 = request.getParameter("buisness_year"); // buisness_year
			String v5 = request.getParameter("doc_id"); // doc_id
			String v6 = request.getParameter("posting_date"); // posting_date
			String v7 = request.getParameter("document_create_date"); // document_create_date
			String v8 = request.getParameter("due_in_date"); // due_in_date
			String v9 = request.getParameter("invoice_currency"); // invoice_currency
			String v10 = request.getParameter("doc_type"); // doc_type
			String v11 = request.getParameter("posting_id"); // positng_id
			String v12 = request.getParameter("total_open_amount"); // total_open_amount
			String v13 = request.getParameter("baseline_create_date"); // baseline_create_date
			String v14 = request.getParameter("cust_payment_terms"); // cust_payment_terms
			String v15 = request.getParameter("invoice_id"); // invoice_id
			// String a16=request.getParameter("p16"); //is_open

			String Insert_query = "INSERT INTO WINTER_INTERNSHIP (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES('"
					+ v1 + "','" + v2 + "','" + v3 + "','" + v4 + "','" + v5 + "','" + v6 + "','" + v7 + "'," + "'" + v8
					+ "','" + v9 + "','" + v10 + "','" + v11 + "'," + "'" + v12 + "','" + v13 + "','" + v14 + "','"
					+ v15 + "')";
			int rs = st.executeUpdate(Insert_query);
			System.out.print(Insert_query);
			System.out.println(rs);
			response.setHeader("Access-Control-Allow-Origin", "*");


		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
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
