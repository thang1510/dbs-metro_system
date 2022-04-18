package ticket.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticket.dao.TicketDao;
import ticket.domain.Ticket;

/**
 * Servlet implementation class TicketServlet
 */

public class TicketServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketServletUpdate() {
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
		TicketDao ticketDao = new TicketDao();
		Ticket ticket = null;

		if(method.equals("search"))
		{
			try {
				ticket = ticketDao.findByTicketID(Integer.parseInt(request.getParameter("ticket_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(ticket.getTicket_id() != null){
				request.setAttribute("ticket", ticket);
				request.getRequestDispatcher("/jsps/ticket/ticket_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Ticket not found");
				request.getRequestDispatcher("/jsps/ticket/ticket_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Ticket form = new Ticket();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setTicket_id(Integer.parseInt(info.get(1)));
			form.setTrain_id(Integer.parseInt(info.get(2)));
			form.setStation_depart(info.get(3));
			form.setStation_arrive(info.get(4));
			form.setTime_depart(java.sql.Timestamp.valueOf(info.get(5)));
			form.setTime_arrive(java.sql.Timestamp.valueOf(info.get(6)));

			try {
				ticketDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Ticket Updated");
			request.getRequestDispatcher("/jsps/ticket/ticket_read_output.jsp").forward(request, response);
		}
	}
}



