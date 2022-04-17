package train.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import train.dao.TrainDao;
import train.domain.Train;


/**
 * Servlet implementation class UserServlet
 */

public class TrainServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainServletDelete() {
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
		
			if(train.getTrain_id() !=null){
						System.out.println(train);
						request.setAttribute("train", train);
						request.getRequestDispatcher("/jsps/train/train_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Train not found");
				request.getRequestDispatcher("/jsps/train/train_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				trainDao.delete(request.getParameter("train_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Train Deleted");
			request.getRequestDispatcher("/jsps/train/train_read_output.jsp").forward(request, response);
		}
	}
}



