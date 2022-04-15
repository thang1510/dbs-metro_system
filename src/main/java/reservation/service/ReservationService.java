package reservation.service;


import reservation.dao.ReservationDao;
import reservation.domain.Reservation;


/**
 * logic functions such as register, login
 * @author Duc Than Nguyen
 *
 */
public class ReservationService {
	private ReservationDao reservationDao = new ReservationDao();
	
	/**
	 * register a Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
		
	public void create(Reservation form) throws ReservationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Reservation entity1 = reservationDao.findByReservationID(form.getReservation_id());
		if(entity1.getReservation_id() !=null && entity1.getReservation_id() == form.getReservation_id()) throw new ReservationException("This reservation id has been registered before!");
		reservationDao.add(form);
	}
}
