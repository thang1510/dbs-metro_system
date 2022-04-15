package ticket.domain;

import java.sql.Timestamp;

/**
 * Passenger object
 * 
 * @author Huu Thuan Thang Nguyen
 * 
 */
public class Ticket {
	/*
	 * Correspond to the user table
	 */
	
	private Integer ticket_id;
	private Integer train_id;
	private String station_depart; 
	private String station_arrive;
	private Timestamp time_depart;
	private Timestamp time_arrive;
	/**
	 * @return the ticket_id
	 */
	public Integer getTicket_id() {
		return ticket_id;
	}
	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}
	/**
	 * @return the train_id
	 */
	public Integer getTrain_id() {
		return train_id;
	}
	/**
	 * @param train_id the train_id to set
	 */
	public void setTrain_id(Integer train_id) {
		this.train_id = train_id;
	}
	/**
	 * @return the station_depart
	 */
	public String getStation_depart() {
		return station_depart;
	}
	/**
	 * @param station_depart the station_depart to set
	 */
	public void setStation_depart(String station_depart) {
		this.station_depart = station_depart;
	}
	/**
	 * @return the station_arrive
	 */
	public String getStation_arrive() {
		return station_arrive;
	}
	/**
	 * @param station_arrive the station_arrive to set
	 */
	public void setStation_arrive(String station_arrive) {
		this.station_arrive = station_arrive;
	}
	/**
	 * @return the time_depart
	 */
	public Timestamp getTime_depart() {
		return time_depart;
	}
	/**
	 * @param time_depart the time_depart to set
	 */
	public void setTime_depart(Timestamp time_depart) {
		this.time_depart = time_depart;
	}
	/**
	 * @return the time_arrive
	 */
	public Timestamp getTime_arrive() {
		return time_arrive;
	}
	/**
	 * @param time_arrive the time_arrive to set
	 */
	public void setTime_arrive(Timestamp time_arrive) {
		this.time_arrive = time_arrive;
	}

	
}
