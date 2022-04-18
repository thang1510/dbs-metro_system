package reservation.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.dao.ReservationDao;
import reservation.domain.Reservation;

/**
 * Servlet implementation class UserServlet
 */

public class ReservationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServletUpdate() {
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
		ReservationDao reservationDao = new ReservationDao();
		Reservation reservation = null;

		if(method.equals("search"))
		{
			try {
				reservation = reservationDao.findByReservationID(Integer.parseInt(request.getParameter("reservation_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(reservation.getReservation_id() != null){
				request.setAttribute("reservation", reservation);
				request.getRequestDispatcher("/jsps/reservation/reservation_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Reservation not found");
				request.getRequestDispatcher("/jsps/reservation/reservation_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Reservation form = new Reservation();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setReservation_id(Integer.parseInt(info.get(1)));
			form.setPassenger_id(Integer.parseInt(info.get(2)));
			form.setTicket_id(Integer.parseInt(info.get(3)));
			form.setReservation_status(Boolean.parseBoolean(info.get(4)));
			form.setReservation_date(java.sql.Timestamp.valueOf(info.get(5)));

			try {
				reservationDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Reservation Updated");
			request.getRequestDispatcher("/jsps/reservation/reservation_read_output.jsp").forward(request, response);
		}
	}
}



