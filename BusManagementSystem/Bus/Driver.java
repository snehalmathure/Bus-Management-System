package com.BusManagementSystem.Bus;



	

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "DriverTable")
	public class Driver {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer driverId;
		
		
		private String name;
		private Integer age;
		private String driverEmail;
		private String idProofNo;
		private Integer mobileNo;
		
		
		public Driver() {
			
		}
		
		public Driver(Integer driverId,String name, Integer age,String driverEmail,String idProofNo,Integer mobileNo){
			
			this.name=name;
			this.age=age;
			this.driverEmail=driverEmail;
			this.idProofNo=idProofNo;
			this.mobileNo=mobileNo;
			
		}
		
		public Integer getDriverId() {
			return driverId;
		}
		public void setDriverId(Integer driverId) {
			this.driverId = driverId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getDriverEmail() {
			return driverEmail;
		}
		public void setDriverEmail(String driverEmail) {
			this.driverEmail = driverEmail;
		}
		

		public Integer getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(Integer mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getIdProofNo() {
			return idProofNo;
		}
		public void setIdProofNo(String idProofNo) {
			this.idProofNo = idProofNo;
		}

		@Override
		public String toString() {
			return "Driver [driverId=" + driverId + ", name=" + name + ", age=" + age + ", driverEmail=" + driverEmail
					+ ", idProofNo=" + idProofNo + ", mobileNo=" + mobileNo + "]";
		}
		
		
		
		
		
	}


