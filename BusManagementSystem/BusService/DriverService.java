package com.BusManagementSystem.BusService;



	import java.util.List;
	import java.util.Optional;

import com.BusManagementSystem.Bus.Driver;

	

	public interface DriverService {

		// Method to save a new Bus entity to the database
	    Driver saveDriverDetails(Driver driver);

	    // Method to retrieve all Bus entities from the database
	    List<Driver> getDriverDetailsFromDb(String str);

	    // Method to retrieve a specific Bus entity by its ID
	    Optional<Driver> getDriverDetailsById(int driverId);

	    // Method to update an existing Bus entity in the database based on its ID
	    Driver updateDriverDetailsById( Optional<Driver> driverDet,Driver newVal);

	    // Method to delete a specific Bus entity from the database based on its ID
	    void deleteDriverDetailsById(int driverId);

	    
	   
		
	}

