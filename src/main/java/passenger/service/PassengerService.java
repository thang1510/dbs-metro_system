package passenger.service;


import java.util.List;

import passenger.dao.PassengerDao;
import passenger.domain.Passenger;


/**
 * logic functions such as register, login
 * @author Duc Than Nguyen & Huu Thuan Thang Nguyen
 *
 */
public class PassengerService {
	private PassengerDao passengerDao = new PassengerDao();
	
	/**
	 * register a Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
		
	public void create(Passenger form) throws PassengerException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Passenger entity1 = passengerDao.findByPassengerID(form.getPassenger_id());
		if(entity1.getPassenger_id() !=null && entity1.getPassenger_id() == form.getPassenger_id()) throw new PassengerException("This passenger id has been registered before!");
		passengerDao.add(form);
	}
	
	public List<Object> findPassenger() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return passengerDao.findPassenger();
	}
	
	public List<Object> findPassengerComplex() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return passengerDao.findPassengerComplex();
	}
}
