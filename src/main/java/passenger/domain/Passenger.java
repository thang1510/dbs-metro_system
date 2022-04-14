package passenger.domain;

import java.sql.Timestamp;

/**
 * Passenger object
 * 
 * @author Duc Than Nguyen
 * 
 */
public class Passenger {
	/*
	 * Correspond to the user table
	 */
	
	private Integer passenger_id;
	private String fullname; 
	private String address;
	private Timestamp join_date;
	/**
	 * @return the passenger_id
	 */
	public Integer getPassenger_id() {
		return passenger_id;
	}
	/**
	 * @param passenger_id the passenger_id to set
	 */
	public void setPassenger_id(Integer passenger_id) {
		this.passenger_id = passenger_id;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the join_date
	 */
	public Timestamp getJoin_date() {
		return join_date;
	}
	/**
	 * @param join_date the join_date to set
	 */
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	

	
	
	
}
