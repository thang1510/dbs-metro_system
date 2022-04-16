package reservation.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.dao.ReservationDao;
import reservation.domain.Reservation;


/**
 * Servlet implementation class UserServlet
 */

public class ReservationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServletRead() {
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
		Reservation reservation = null;
		ReservationDao reservationDao = new ReservationDao();
		
		try {
			reservation = reservationDao.findByReservationID(Integer.parseInt(request.getParameter("reservation_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(reservation.getReservation_id() !=null){
					request.setAttribute("reservation", reservation);
					request.getRequestDispatcher("/jsps/reservation/reservation_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Reservation not found");
			request.getRequestDispatcher("/jsps/reservation/reservation_read_output.jsp").forward(request, response);
		}
	}
}



