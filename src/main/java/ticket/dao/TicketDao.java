package ticket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import ticket.domain.Ticket;

/**
 * DDL functions performed in database
 */
public class TicketDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "metro_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "admin@123"; //TODO change password

	public Ticket findByTicketID(Integer ticket_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Ticket ticket = new Ticket();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
		    String sql = "select * from ticket where ticket_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ticket_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer ticket_id = Integer.parseInt(resultSet.getString("ticket_id"));
		    	if(ticket_id == ticket_id_p){
		    		ticket.setTicket_id(ticket_id);
		    		ticket.setTrain_id(Integer.parseInt(resultSet.getString("train_id")));
		    		ticket.setStation_depart(resultSet.getString("station_depart"));
		    		ticket.setStation_arrive(resultSet.getString("station_arrive"));
		    		ticket.setTime_depart(java.sql.Timestamp.valueOf(resultSet.getString("time_depart")));
		    		ticket.setTime_arrive(java.sql.Timestamp.valueOf(resultSet.getString("time_arrive")));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return ticket;
	}	
	
	/**
	 * insert Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Ticket form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "insert into ticket(ticket_id, train_id, station_depart, station_arrive, time_depart,  time_arrive) values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getTicket_id());
		    preparestatement.setInt(2,form.getTrain_id());
		    preparestatement.setString(3,form.getStation_depart());
		    preparestatement.setString(4,form.getStation_arrive());
		    preparestatement.setTimestamp(5,form.getTime_depart());
		    preparestatement.setTimestamp(6,form.getTime_arrive());
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
	/*
	public void update(Entity1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getPassword());
			preparestatement.setString(2,form.getEmail());
		    preparestatement.setString(3,form.getUsername());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	*/
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	/*
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "delete from entity1 where username = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	*/
}
