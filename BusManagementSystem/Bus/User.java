package com.BusManagementSystem.Bus;


	
	import java.sql.Date;
import java.time.LocalDate;

	import org.hibernate.annotations.DynamicUpdate;

	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.NamedQueries;
	import jakarta.persistence.NamedQuery;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "User_table")
	@DynamicUpdate
	public class User {

			
		@Id
			private Integer userID;
			private String userName;
			private int noOfSeats;
			private Date date;
			private String userEmail;
			
			@ManyToOne(cascade = CascadeType.ALL)
			@JoinColumn(name="busId")
			private Bus busDetails;

			public User() {
				
			}

			public int getNoOfSeats() {
				return noOfSeats;
			}

			public void setNoOfSeats(int noOfSeats) {
				this.noOfSeats = noOfSeats;
			}

			public Integer getUserID() {
				return userID;
			}

			public String getUserName() {
				return userName;
			}

			public Date getDate() {
				return date;
			}

			public String getUserEmail() {
				return userEmail;
			}

			public Bus getBusDetails() {
				return busDetails;
			}


			public void setUserID(Integer userID) {
				this.userID = userID;
			}


			public void setUserName(String userName) {
				this.userName = userName;
			}


			public void setDate(Date date) {
				this.date = date;
			}


			public void setUserEmail(String userEmail) {
				this.userEmail = userEmail;
			}


			public void setBusDetails(Bus busDetails) {
				this.busDetails = busDetails;
			}
			
			private String gender;
			public String getGender() {
				return gender;
			}

			public void setGender(String gender) {
				this.gender = gender;
			}


			@Override
			public String toString() {
				return "User [userID=" + userID + ", userName=" + userName + ", noOfSeats=" + noOfSeats + ", date="
						+ date + ", userEmail=" + userEmail + ", busDetails=" + busDetails + "]";
			}

			

			
	}


