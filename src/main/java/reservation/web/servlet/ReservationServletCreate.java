package reservation.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.domain.Reservation;
import reservation.service.ReservationException;
import reservation.service.ReservationService;


/**
 * Servlet implementation class UserServlet
 */

public class ReservationServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServletCreate() {
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
		ReservationService entity1service = new ReservationService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Reservation form = new Reservation();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setReservation_id(Integer.parseInt(info.get(0)));
		form.setPassenger_id(Integer.parseInt(info.get(1)));
		form.setTicket_id(Integer.parseInt(info.get(2)));
		form.setReservation_status(Boolean.parseBoolean(info.get(3)));
		form.setReservation_date(java.sql.Timestamp.valueOf(info.get(4)));

		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | ReservationException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
