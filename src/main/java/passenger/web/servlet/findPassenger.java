package passenger.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import passenger.service.PassengerService;

/**
 * Servlet implementation class findPassenger
 */

public class findPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PassengerService passengerService = new PassengerService();
		try {
			request.setAttribute("PassengerList", passengerService.findPassenger());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		//simple query
		request.getRequestDispatcher("/jsps/passenger/q2_passenger_view.jsp").forward(request, response);
	}

}
