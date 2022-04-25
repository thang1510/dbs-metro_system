package train.domain;


/**
 * Train object
 * 
 * @author Duc Than Nguyen
 * 
 */
public class Train {
	/*
	 * Correspond to the user table
	 */
	
	private Integer train_id;
	private Integer seat_number;
	private String train_name; 
	private byte train_status;
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
	 * @return the seat_number
	 */
	public Integer getSeat_number() {
		return seat_number;
	}
	/**
	 * @param seat_number the seat_number to set
	 */
	public void setSeat_number(Integer seat_number) {
		this.seat_number = seat_number;
	}
	/**
	 * @return the train_name
	 */
	public String getTrain_name() {
		return train_name;
	}
	/**
	 * @param train_name the train_name to set
	 */
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	/**
	 * @return the train_status
	 */
	public byte getTrain_status() {
		return train_status;
	}
	/**
	 * @param train_status the train_status to set
	 */
	public void setTrain_status(byte train_status) {
		this.train_status = train_status;
	}
	
	
	
}
