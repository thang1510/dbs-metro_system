package ticket.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticket.dao.TicketDao;
import ticket.domain.Ticket;


/**
 * Servlet implementation class TicketServlet
 */

public class TicketServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServletRead() {
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
		Ticket ticket = null;
		TicketDao ticketDao = new TicketDao();
		
		try {
			ticket = ticketDao.findByTicketID(Integer.parseInt(request.getParameter("ticket_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(ticket.getTicket_id()!=null){
					request.setAttribute("ticket", ticket);
					request.getRequestDispatcher("/jsps/ticket/ticket_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Ticket not found");
			request.getRequestDispatcher("/jsps/ticket/ticket_read_output.jsp").forward(request, response);
		}
	}
}



