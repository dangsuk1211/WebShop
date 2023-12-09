package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOs.PaymentDAO;
import model.entity.Client;
import model.entity.Payment;
@WebServlet("/Trangchu/Payment")
public class PagePayment extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");

		RequestDispatcher dispatcher=req.getRequestDispatcher("/Pages/ActionDataPage/Payment.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    String money=(String) req.getParameter("money");
	    String cardholderName=(String) req.getParameter("name");
	    HttpSession ses=req.getSession();
	    Client client=(Client) ses.getAttribute("user");
	    PaymentDAO.addPaymentToData(new Payment(0, cardholderName, client.getFullName(),0,client.getId() ,money), "payment");
	    resp.sendRedirect(req.getContextPath()+"/Trangchu");
	}
}
