package ticket.service;


import java.util.List;

import ticket.dao.TicketDao;
import ticket.domain.Ticket;


/**
 * logic functions such as register, login
 * @author Huu Thuan Thang Nguyen
 *
 */
public class TicketService {
	private TicketDao ticketDao = new TicketDao();
	
	/**
	 * register a Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
		
	public void create(Ticket form) throws TicketException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Ticket entity1 = ticketDao.findByTicketID(form.getTicket_id());
		if(entity1.getTicket_id() !=null && entity1.getTicket_id() == form.getTicket_id()) throw new TicketException("This ticket id has been registered before!");
		ticketDao.add(form);
	}
	
	public List<Object> findTicket() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return ticketDao.findTicket();
		
	}
}
