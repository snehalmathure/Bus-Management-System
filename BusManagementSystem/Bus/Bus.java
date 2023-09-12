package com.BusManagementSystem.Bus;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Bus_Table")
@DynamicUpdate


/**
 * In this class,we declare private attributes for software details
 * provide getters and setters for accessing attributes
 */

public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;

	@Column(name = "driver_Name", nullable = false)
	private String driverName;
	
	@Column(name = "source", nullable = false)
	private String source;

	


	@Column(name = "destination", nullable = false)
	private String destination;

	@Column(name = "averageCost", nullable = false)
	private int average_cost;
	
	
	@Column(name="AC_Bus", nullable = false)
	private Boolean isACBus;
	
	
	@Column(name="totalSeat", nullable = false )
	private int total_seat;
	
	@Column(name="traveler_Name", nullable = false )
	private String travelerName;
	
	@Column(name="Rating", nullable = false )
	private int ratings;
	
	
	public Bus() {}
	

	public Bus(Integer busId, String driverName, String source,String destination, int average_cost, Boolean isACBus, int total_seat,
			String travelerName,int ratings) {
		
		this.busId = busId;
		this.driverName = driverName;
		this.source=source;
		this.destination = destination;
		this.average_cost = average_cost;
		this.isACBus = isACBus;
		this.total_seat = total_seat;
		this.travelerName = travelerName;
		this.ratings=ratings;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getAverage_cost() {
		return average_cost;
	}

	public void setAverage_cost(int average_cost) {
		this.average_cost = average_cost;
	}

	
	

	public Boolean getIsACBus() {
		return isACBus;
	}

	public void setIsACBus(Boolean isACBus) {
		this.isACBus = isACBus;
	}

	public int getTotal_seat() {
		return total_seat;
	}


	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

	public String getTravelerName() {
		return travelerName;
	}

	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}


	


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}


	public Integer getBusId() {
		return busId;
	}


	public void setBusId(Integer busId) {
		this.busId = busId;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", driverName=" + driverName + ", source=" + source + ", destination="
				+ destination + ", average_cost=" + average_cost + ", isACBus=" + isACBus + ", total_seat=" + total_seat
				+ ", travelerName=" + travelerName + ", ratings=" + ratings + "]";
	}


	
	

}
