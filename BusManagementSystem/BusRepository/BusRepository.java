package com.BusManagementSystem.BusRepository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BusManagementSystem.Bus.Bus;


/**
 *Bus Repository interface is spring Data JPA Repository that provides 
 *database access and CRUD operations for the bus entity
 */

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

	
	//List< Bus> findByTravelersNmaeContainingIgnoreCase(String travelerName);

	List<Bus> findByIsACBus(boolean status);

	List<Bus> findByTravelerNameContainingIgnoreCase(String travelerName);
	List<Bus>findBySourceAndDestination(String source,String destination);
	
	List<Bus> findByDriverNameContainingIgnoreCase(String driverName);

}

