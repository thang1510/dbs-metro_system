package passenger.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import passenger.dao.PassengerDao;
import passenger.domain.Passenger;


/**
 * Servlet implementation class UserServlet
 */

public class PassengerServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerServletRead() {
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
		Passenger passenger = null;
		PassengerDao passengerDao = new PassengerDao();
		
		try {
			passenger = passengerDao.findByPassengerID(Integer.parseInt(request.getParameter("passenger_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(passenger.getPassenger_id()!=null){
					request.setAttribute("passenger", passenger);
					request.getRequestDispatcher("/jsps/passenger/passenger_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Passenger not found");
			request.getRequestDispatcher("/jsps/passenger/passenger_read_output.jsp").forward(request, response);
		}
	}
}



