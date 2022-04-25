package train.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import train.dao.TrainDao;
import train.domain.Train;

/**
 * Servlet implementation class TrainServlet
 */

public class TrainServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainServletUpdate() {
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
		TrainDao trainDao = new TrainDao();
		Train train = null;

		if(method.equals("search"))
		{
			try {
				train = trainDao.findByTrainID(Integer.parseInt(request.getParameter("train_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(train.getTrain_id() != null){
				request.setAttribute("train", train);
				request.getRequestDispatcher("/jsps/train/train_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Train not found");
				request.getRequestDispatcher("/jsps/train/train_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Train form = new Train();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setTrain_id(Integer.parseInt(info.get(1)));
			form.setSeat_number(Integer.parseInt(info.get(2)));
			form.setTrain_name(info.get(3));
			form.setTrain_status(Byte.valueOf(info.get(4)));

			try {
				trainDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Train Updated");
			request.getRequestDispatcher("/jsps/train/train_read_output.jsp").forward(request, response);
		}
	}
}



