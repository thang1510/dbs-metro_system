package train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
	public void update(Train form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE train SET seat_number = ?, train_name = ?, train_status = ? where train_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getSeat_number());
		    preparestatement.setString(2,form.getTrain_name());
		    preparestatement.setBoolean(3,form.getTrain_status());
		    preparestatement.setInt(4,form.getTrain_id());
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
	public void delete(String train_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			
			String sql = "delete from train where train_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(train_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findTrain() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbs_metro_system", MySQL_user, MySQL_password);
			//String sql = "select * from train_aggregate";
			String sql = "SELECT * FROM dbs_metro_system.train WHERE seat_number < ( SELECT AVG(seat_number) FROM dbs_metro_system.train ) and LENGTH(train_name) > 3;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, String> train = new Hashtable<String, String>();
				train.put("train_id", resultSet.getString("train_id"));
				train.put("seat_number", resultSet.getString("seat_number"));
				train.put("train_name", resultSet.getString("train_name"));
				train.put("train_status", resultSet.getString("train_status"));
				
				list.add(train);
	    		
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
