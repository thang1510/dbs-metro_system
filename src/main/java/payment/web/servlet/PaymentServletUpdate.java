package payment.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.PaymentDao;
import payment.domain.Payment;

/**
 * Servlet implementation class PaymentServlet
 */

public class PaymentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		PaymentDao paymentDao = new PaymentDao();
		Payment payment = null;

		if(method.equals("search"))
		{
			try {
				payment = paymentDao.findByPaymentID(Integer.parseInt(request.getParameter("payment_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(payment.getPayment_id() != null){
				request.setAttribute("payment", payment);
				request.getRequestDispatcher("/jsps/payment/payment_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Payment not found");
				request.getRequestDispatcher("/jsps/payment/payment_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Payment form = new Payment();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setPayment_id(Integer.parseInt(info.get(1)));
			form.setReservation_id(Integer.parseInt(info.get(2)));
			form.setPayment_date(java.sql.Timestamp.valueOf(info.get(3)));
			form.setAmount(BigDecimal.valueOf(Double.valueOf(info.get(4))));
			
			
			try {
				paymentDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Payment Updated");
			request.getRequestDispatcher("/jsps/payment/payment_read_output.jsp").forward(request, response);
		}
	}
}



