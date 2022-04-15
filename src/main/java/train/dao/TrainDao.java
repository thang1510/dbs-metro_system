package train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import train.domain.Train;

/**
 * DDL functions performed in database
 */
public class TrainDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "metro_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "admin@123"; //TODO change password

	public Train findByTrainID(Integer train_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Train train = new Train();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
		    String sql = "select * from train where train_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,train_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer train_id = Integer.parseInt(resultSet.getString("train_id"));
		    	if(train_id == train_id_p){
		    		train.setTrain_id(train_id);
		    		train.setSeat_number(Integer.parseInt(resultSet.getString("seat_number")));
		    		train.setTrain_name(resultSet.getString("train_name"));
		    		train.setTrain_status(Boolean.parseBoolean(resultSet.getString("train_status")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return train;
	}	
	
	/**
	 * insert Passenger
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Train form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "insert into train(train_id, seat_number, train_name, train_status) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getTrain_id());
		    preparestatement.setInt(2,form.getSeat_number());
		    preparestatement.setString(3,form.getTrain_name());
		    preparestatement.setBoolean(4,form.getTrain_status());
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
