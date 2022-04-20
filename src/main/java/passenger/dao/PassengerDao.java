package passenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import passenger.domain.Passenger;

/**
 * DDL functions performed in database
 */
public class PassengerDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "metro_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "admin@123"; //TODO change password

	public Passenger findByPassengerID(Integer passenger_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Passenger passenger = new Passenger();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
		    String sql = "select * from passenger where passenger_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,passenger_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer passenger_id = Integer.parseInt(resultSet.getString("passenger_id"));
		    	if(passenger_id == passenger_id_p){
		    		passenger.setPassenger_id(passenger_id);
		    		passenger.setFullname(resultSet.getString("fullname"));
		    		passenger.setAddress(resultSet.getString("address"));
		    		passenger.setJoin_date(java.sql.Timestamp.valueOf(resultSet.getString("join_date")));
		    		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return passenger;
	}	
	
	/**
	 * insert Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Passenger form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "insert into passenger(passenger_id, fullname, address, join_date) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPassenger_id());
		    preparestatement.setString(2,form.getFullname());
		    preparestatement.setString(3,form.getAddress());
		    preparestatement.setTimestamp(4,form.getJoin_date());
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
	public void update(Passenger form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE passenger SET fullname = ?, address = ?, join_date = ? where passenger_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFullname());
		    preparestatement.setString(2,form.getAddress());
		    preparestatement.setTimestamp(3,form.getJoin_date());
		    preparestatement.setInt(4,form.getPassenger_id());
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

	public void delete(String passenger_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "delete from passenger where passenger_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(passenger_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findPassenger() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			//String sql = "select * from passenger_view";
			String sql = "SELECT * FROM dbs_metro_system.passenger WHERE join_date <= '2020-01-05 00:00:00' ORDER BY join_date;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, String> passenger = new Hashtable<String, String>();
				passenger.put("passenger_id", resultSet.getString("passenger_id"));
				passenger.put("fullname", resultSet.getString("fullname"));
				passenger.put("address", resultSet.getString("address"));
				passenger.put("join_date", resultSet.getString("join_date"));
				
				list.add(passenger);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
