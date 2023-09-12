package com.BusManagementSystem.BusService;

import java.util.List;
import java.util.Optional;

import com.BusManagementSystem.Bus.Bus;


/* The BusSErvice is service interface 
 * and abstract method declaration
  */
public interface BusService {

	Bus saveBusDetails(Bus bus);
	List<Bus>  getBusFromDb(String travelerName);
	Bus updateBusDetails(Optional<Bus> busDetails ,Bus newBusVal);
	Optional<Bus> getBusById(int busId);
	void deleteBusById(int busId);
	void deleteAllBuses();
	List<Bus>findByIsACBus(boolean status);
	

}



