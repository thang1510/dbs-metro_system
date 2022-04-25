package reservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import reservation.domain.Reservation;

/**
 * DDL functions performed in database
 */
public class ReservationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "metro_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "admin@123"; //TODO change password

	public Reservation findByReservationID(Integer reservation_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Reservation reservation = new Reservation();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
		    String sql = "select * from reservation where reservation_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,reservation_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer reservation_id = Integer.parseInt(resultSet.getString("reservation_id"));
		    	if(reservation_id == reservation_id_p){
		    		
		    		reservation.setReservation_id(reservation_id);
		    		reservation.setPassenger_id(Integer.parseInt(resultSet.getString("passenger_id")));
		    		reservation.setTicket_id(Integer.parseInt(resultSet.getString("ticket_id")));
		    		reservation.setReservation_status(Byte.parseByte(resultSet.getString("reservation_status")));
		    		reservation.setReservation_date(java.sql.Timestamp.valueOf(resultSet.getString("reservation_date")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return reservation;
	}	
	
	/**
	 * insert Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Reservation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "insert into reservation(reservation_id, passenger_id, ticket_id, reservation_status, reservation_date) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getReservation_id());
		    preparestatement.setInt(2,form.getPassenger_id());
		    preparestatement.setInt(3,form.getTicket_id());
		    preparestatement.setByte(4, form.getReservation_status());
		    preparestatement.setTimestamp(5,form.getReservation_date());
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
	public void update(Reservation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE reservation SET passenger_id = ?, ticket_id = ?, reservation_status = ?, reservation_date = ?  where reservation_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPassenger_id());
		    preparestatement.setInt(2,form.getTicket_id());
		    preparestatement.setByte(3, form.getReservation_status());
		    preparestatement.setTimestamp(4,form.getReservation_date());
		    preparestatement.setInt(5,form.getReservation_id());
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

	public void delete(String reservation_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "delete from reservation where reservation_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(reservation_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
