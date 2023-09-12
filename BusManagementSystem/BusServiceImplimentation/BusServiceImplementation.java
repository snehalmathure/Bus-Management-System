package com.BusManagementSystem.BusServiceImplimentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.BusManagementSystem.Bus.Bus;
import com.BusManagementSystem.BusRepository.BusRepository;
import com.BusManagementSystem.BusService.BusService;


/* The BusServiceImplementation class is a service class that provides the business logic 
It implements the BusSErvice interface to perform operations(Insert, Read, Update, Delete) on items.
 */
@Service
public class BusServiceImplementation implements BusService{

	BusRepository busRepository;

	public BusServiceImplementation(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	//Save Bus Details
	@Override
	public Bus saveBusDetails(Bus bus) {
		return busRepository.save(bus);  
	}




	//get All Bus Details
	@Override
	public List<Bus> getBusFromDb(String name) {
		List<Bus>bus = new ArrayList<Bus>();

		if (name == null) 
			busRepository.findAll().forEach(bus::add);


		else
			busRepository.findByTravelerNameContainingIgnoreCase(name).forEach(bus::add);

		return bus;
	}


	//Find Bus Detail by Specific ID
	@Override//5
	public Optional<Bus> getBusById(int busId) { 
		Optional<Bus> bus=busRepository.findById(busId);
		return bus;
	}

	//find Bus by Destination
	public Bus getByDestination(int busId) {
		Optional<Bus> bus = busRepository.findById(busId);
		System.out.println(busId);
		System.out.println(bus.isPresent());
		if(bus.isPresent()) {
			Bus obj=bus.get();
			System.out.println(obj);
			return bus.get();
		}
		else {
			return null;
		}
	}

	//update Bus By specific ID
	//@Override
	public Bus updateBusDetails(Optional<Bus> busDetails ,Bus newBusVal) {

		/*Optional<Bus> bus = busRepository.findById(busId);
			if(bus.isPresent()) {*/

		Bus existingBus = busDetails.get();  
		existingBus.setDriverName(newBusVal.getDriverName());
		existingBus.setSource(newBusVal.getSource());
		existingBus.setDestination(newBusVal.getDestination());
		existingBus.setAverage_cost(newBusVal.getAverage_cost());
		existingBus.setTotal_seat(newBusVal.getTotal_seat());
		existingBus.setIsACBus(newBusVal.getIsACBus());
		existingBus.setTravelerName(newBusVal.getTravelerName());
		existingBus.setRatings(newBusVal.getRatings());

		return busRepository.save(existingBus);

	}

	//Delete Bus Detail by ID
	@Override
	public void deleteBusById(int busId) {

		busRepository.deleteById(busId);
	}	


	//Delete All Bus Details
	public void deleteAllBuses() {
		busRepository.deleteAll();

	}




	public List<Bus> findByTravelerNameContainingIgnoreCase(String travelerName) {
		List<Bus> busList = new ArrayList<Bus>();
		busRepository.findByTravelerNameContainingIgnoreCase(travelerName).forEach(busList::add);
		return busList;


	}


	//Find Bus By AC or NonAC Status
	public List<Bus> findByIsACBus(boolean status) {

		return busRepository.findByIsACBus(status);
	}


	public List<Bus> getBusDetails(String source, String destination) {

		List<Bus> bus = new ArrayList<Bus>();


		busRepository.findBySourceAndDestination(source,destination).forEach(bus::add);

		return bus;
	}

	public List<Bus> getAllBusByDriverName(String name) {

		List<Bus> bus = new ArrayList<Bus>();


		busRepository.findByDriverNameContainingIgnoreCase(name).forEach(bus::add);

		return bus;
	}


	public List<Bus> getAllBusByPriceDesc(String direction,String price) {

		List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),price));
		return bus;
	}

	public List<Bus> getAllBusByRatingsDesc(String direction,String ratings) {

		List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),ratings));
		return bus;
	}



	private Sort.Direction getSortDirection(String direction){
		if(direction.equals("asc")){
			System.out.println("came here");
			return Sort.Direction.ASC;
		}
		else if(direction.equals("desc")) {
			System.out.println("came here desc");
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;

	}




}