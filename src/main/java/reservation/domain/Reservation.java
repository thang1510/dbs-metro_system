package reservation.domain;

import java.sql.Timestamp;

/**
 * Reservation object
 * 
 * @author Duc Than Nguyen
 * 
 */
public class Reservation {
	/*
	 * Correspond to the user table
	 */
	
	private Integer reservation_id;
	private Integer passenger_id; 
	private Integer ticket_id;
	private Boolean reservation_status;
	private Timestamp reservation_date;
	
	/**
	 * @return the reservation_id
	 */
	public Integer getReservation_id() {
		return reservation_id;
	}
	/**
	 * @param reservation_id the reservation_id to set
	 */
	public void setReservation_id(Integer reservation_id) {
		this.reservation_id = reservation_id;
	}
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
	 * @return the reservation_status
	 */
	public Boolean getReservation_status() {
		return reservation_status;
	}
	/**
	 * @param reservation_status the reservation_status to set
	 */
	public void setReservation_status(Boolean reservation_status) {
		this.reservation_status = reservation_status;
	}
	/**
	 * @return the reservation_date
	 */
	public Timestamp getReservation_date() {
		return reservation_date;
	}
	/**
	 * @param reservation_date the reservation_date to set
	 */
	public void setReservation_date(Timestamp reservation_date) {
		this.reservation_date = reservation_date;
	}
		
	
}
