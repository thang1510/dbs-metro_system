package train.service;


import train.dao.TrainDao;
import train.domain.Train;


/**
 * logic functions such as register, login
 * @author Duc Than Nguyen
 *
 */
public class TrainService {
	private TrainDao trainDao = new TrainDao();
	
	/**
	 * register a Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
		
	public void create(Train form) throws TrainException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Train entity1 = trainDao.findByTrainID(form.getTrain_id());
		if(entity1.getTrain_id() !=null && entity1.getTrain_id() == form.getTrain_id()) throw new TrainException("This train id has been registered before!");
		trainDao.add(form);
	}
}
