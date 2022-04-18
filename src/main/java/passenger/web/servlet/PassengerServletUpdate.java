package passenger.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import passenger.dao.PassengerDao;
import passenger.domain.Passenger;

/**
 * Servlet implementation class PassengerServlet
 */

public class PassengerServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PassengerServletUpdate() {
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
		PassengerDao passengerDao = new PassengerDao();
		Passenger passenger = null;

		if(method.equals("search"))
		{
			try {
				passenger = passengerDao.findByPassengerID(Integer.parseInt(request.getParameter("passenger_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(passenger.getPassenger_id() != null){
				request.setAttribute("passenger", passenger);
				request.getRequestDispatcher("/jsps/passenger/passenger_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Passenger not found");
				request.getRequestDispatcher("/jsps/passenger/passenger_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Passenger form = new Passenger();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setPassenger_id(Integer.parseInt(info.get(1)));
			form.setFullname(info.get(2));
			form.setAddress(info.get(3));
			form.setJoin_date(java.sql.Timestamp.valueOf(info.get(4)));

			try {
				passengerDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Passenger Updated");
			request.getRequestDispatcher("/jsps/passenger/passenger_read_output.jsp").forward(request, response);
		}
	}
}



