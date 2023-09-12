package com.BusManagementSystem.BusController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagementSystem.Bus.Bus;
import com.BusManagementSystem.BusService.BusService;
import com.BusManagementSystem.BusServiceImplimentation.BusServiceImplementation;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bus")

//handle all the request that start with redbus
public class BusController {
	
	public BusServiceImplementation busService;
		public BusController(BusServiceImplementation busService)
		{
		this.busService = busService;
		}

//Add Bus Details API
	@PostMapping
	public ResponseEntity<Bus> saveBus(@RequestBody Bus bus)
	{
		System.out.println(bus);
		try {
			return new ResponseEntity<>(busService.saveBusDetails(bus), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
//Display All Bus Details API
	@GetMapping
	public ResponseEntity<List<Bus>> getAllBus(@RequestParam(required = false) String name) {
		try {
			List <Bus> busList = busService.getBusFromDb(name);
			
			if (busList.isEmpty()) 
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/matchRoutes")
	public ResponseEntity<List<Bus>> getBusDetailsBySoursecDestiation(@RequestParam(required = true) String source, @RequestParam(required = true) String destination) {
			
			try {
				
				List<Bus> busList = busService.getBusDetails(source, destination);

				if (busList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(busList, HttpStatus.OK);  

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@GetMapping("/searchByDriverName")
	public ResponseEntity<List<Bus>> findByDriverName(@RequestParam(required = false) String name) {
		try {
			List <Bus> busList = busService.getAllBusByDriverName(name);
			
			if (busList.isEmpty()) 
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
//Update specific Bus Details By busId
	
		@PutMapping("/{id}")
		public ResponseEntity<Bus> updatebusDetailsById(@PathVariable("id") int busId, @RequestBody Bus busDetails){
			Optional<Bus> busData=busService.getBusById(busId);
			
			if(busData.isPresent())
			{
				
				busService.updateBusDetails(busData, busDetails);
				return new ResponseEntity<>(busService.updateBusDetails(busData, busDetails),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
	
	
//Display specific Bus Details By passing Id	
	@GetMapping("/{id}")
	
	public ResponseEntity<Bus> getBusById(@PathVariable("id")  int busId){
		System.out.println(busId);
		Optional<Bus> bus = busService.getBusById(busId);
		
		if(bus.isPresent())
		{
			return new ResponseEntity<>(bus.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
//Delete specific BusDetails by passing BusId 
	@DeleteMapping("/{id}")	
	public ResponseEntity<String> deleteBusById(@PathVariable("id")  int busId)
	{
		Optional<Bus> busData=busService.getBusById(busId);

		try {
			if(busData.isPresent())
			{
				busService.deleteBusById(busId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
   }
	
	
//Delete All Buses
	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllBus(){
		try
		{
			busService.deleteAllBuses();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	//search ACBus
	@GetMapping("/acBus")
	public ResponseEntity<List<Bus>> findByACDomain() {
		try {
			List<Bus> bus = busService.findByIsACBus(true);

			if (bus.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bus, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//search for NonAcBus
	@GetMapping("/nonACBus")
	public ResponseEntity<List<Bus>> findByNonACDomain() {
		try {

			List<Bus> bus = busService.findByIsACBus(false);

			if (bus.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bus, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@GetMapping("filter/Price/{direction}")
	public ResponseEntity<List<Bus>> getAllBuseByPriceHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String price){
		try {
			System.out.println("i am here!!!");
			List<Bus> busList = busService.getAllBusByPriceDesc(direction,price);
			System.out.println(direction);
			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	
	@GetMapping("filter/Price/{direction}")
	public ResponseEntity<List<Bus>> getAllBuseByPriceHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String price){
		try {
			System.out.println("i am here!!!");
			List<Bus> busList = busService.getAllBusByPriceDesc(direction,price);
			System.out.println(direction);
			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("filter/Rating/{direction}")
	public ResponseEntity<List<Bus>> getAllBuseByRatingHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String ratings){
		try {
			
			List<Bus> busList = busService.getAllBusByRatingsDesc(direction,ratings);

			if (busList.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	/*@GetMapping("/readBusByTravelerName/{travelerName}")
	public ResponseEntity<List<Bus>> getAllBusesByMatchingTravelerName(@PathVariable("travelerName") String travelerName){//al
		
		try {
			
			if(travelerName != null) {
				
				return new ResponseEntity<>(busService.findByTravelerNameContainingIgnoreCase(travelerName), HttpStatus.OK);
			}
		else {
				busList = busRepository.findAll();
				return new ResponseEntity<>(busList, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}*/
	
	
	
	
	/*@GetMapping("/readAllBus")
	public List<Bus> getAllBus(){
		return  busService.getBusFromDb(title);*/
	}

	/*@GetMapping("/getByDestination/{id}")
	public ResponseEntity<Bus> getByDestination(@PathVariable("id") int  busId){
		return new ResponseEntity<Bus>(busService.getByDestination(busId), HttpStatus.OK);
	}*/
	
	
	



	
	
