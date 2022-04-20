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

public class findPassengerComplex extends HttpServlet {
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
			request.setAttribute("PassengerComplex", passengerService.findPassengerComplex());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/jsps/passenger/q4_passenger_complex.jsp").forward(request, response);
	}

}
