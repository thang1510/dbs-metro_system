package payment.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Passenger object
 * 
 * @author Huu Thuan Thang Nguyen
 * 
 */
public class Payment {
	/*
	 * Correspond to the user table
	 */
	
	private Integer payment_id;
	private Integer reservation_id;
	private Timestamp datetime; 
	private BigDecimal amount;
	/**
	 * @return the payment_id
	 */
	public Integer getPayment_id() {
		return payment_id;
	}
	/**
	 * @param payment_id the payment_id to set
	 */
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
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
	 * @return the datetime
	 */
	public Timestamp getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
}
