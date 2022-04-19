package payment.service;


import java.util.List;

import payment.dao.PaymentDao;
import payment.domain.Payment;


/**
 * logic functions such as register, login
 * @author Huu Thuan Thang Nguyen & Duc Than Nguyen 
 *
 */
public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	
	/**
	 * register a Payment
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
		
	public void create(Payment form) throws PaymentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Payment entity1 = paymentDao.findByPaymentID(form.getPayment_id());
		if(entity1.getPayment_id() !=null && entity1.getPayment_id() == form.getPayment_id()) throw new PaymentException("This payment id has been registered before!");
		paymentDao.add(form);
	}
	
	public List<Object> findPayment() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return paymentDao.findPayment();
		
	}
}
