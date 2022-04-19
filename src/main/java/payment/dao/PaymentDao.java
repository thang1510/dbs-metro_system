package payment.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import payment.domain.Payment;
import payment.domain.findPayment;

/**
 * DDL functions performed in database
 */
public class PaymentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "metro_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "admin@123"; //TODO change password

	public Payment findByPaymentID(Integer payment_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Payment payment = new Payment();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
		    String sql = "select * from payment where payment_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,payment_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer payment_id = Integer.parseInt(resultSet.getString("payment_id"));
		    	if(payment_id == payment_id_p){
		    		payment.setPayment_id(payment_id);
		    		payment.setReservation_id(Integer.parseInt(resultSet.getString("reservation_id")));
		    		payment.setPayment_date(java.sql.Timestamp.valueOf(resultSet.getString("payment_date")));
		    		payment.setAmount(BigDecimal.valueOf(Double.valueOf(resultSet.getString("amount"))));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return payment;
	}	
	
	/**
	 * insert Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Payment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "insert into payment(payment_id, reservation_id, payment_date, amount) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPayment_id());
		    preparestatement.setInt(2,form.getReservation_id());
		    preparestatement.setTimestamp(3,form.getPayment_date());
		    preparestatement.setBigDecimal(4,form.getAmount());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Payment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE payment SET reservation_id = ?, payment_date = ?, amount = ? where payment_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setInt(1,form.getReservation_id());
		    preparestatement.setTimestamp(2,form.getPayment_date());
		    preparestatement.setBigDecimal(3,form.getAmount());
		    preparestatement.setInt(4,form.getPayment_id());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String payment_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "delete from payment where payment_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(payment_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findPayment() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			String sql = "select * from payment_aggregate";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				findPayment payment = new findPayment();
				
				
				payment.setPayment_id(Integer.parseInt(resultSet.getString("payment_id")));
	    		payment.setReservation_id(Integer.parseInt(resultSet.getString("reservation_id")));
	    		payment.setPayment_date(java.sql.Timestamp.valueOf(resultSet.getString("payment_date")));
	    		payment.setAmount(BigDecimal.valueOf(Double.valueOf(resultSet.getString("amount"))));	
	    		list.add(payment);
	    		
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findPaymentReservation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			String sql = "select * from payment_reservation_complex";
			//String sql = "SELECT payment.payment_id, payment.reservation_id, reservation.ticket_id FROM dbs_metro_system.payment JOIN dbs_metro_system.reservation WHERE EXISTS ( SELECT payment_id FROM payment ) AND payment.amount > 50000;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, Integer> my_dict = new Hashtable<String, Integer>();
				my_dict.put("payment_id", Integer.parseInt(resultSet.getString("payment_id")));
				my_dict.put("reservation_id", Integer.parseInt(resultSet.getString("reservation_id")));
				my_dict.put("ticket_id", Integer.parseInt(resultSet.getString("ticket_id")));
	
	    		list.add(my_dict);
	    		
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
