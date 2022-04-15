package ticket.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticket.domain.Ticket;
import ticket.service.TicketException;
import ticket.service.TicketService;


/**
 * Servlet implementation class UserServlet
 */

public class TicketServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServletCreate() {
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
		TicketService entity1service = new TicketService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Ticket form = new Ticket();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setTicket_id(Integer.parseInt(info.get(0)));
		form.setTrain_id(Integer.parseInt(info.get(1)));
		form.setStation_depart(info.get(2));
		form.setStation_arrive(info.get(3));
		form.setTime_depart(java.sql.Timestamp.valueOf(info.get(4)));
		form.setTime_arrive(java.sql.Timestamp.valueOf(info.get(5)));

		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | TicketException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
