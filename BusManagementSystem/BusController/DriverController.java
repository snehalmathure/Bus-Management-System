package com.BusManagementSystem.BusController;


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

import com.BusManagementSystem.Bus.Driver;
import com.BusManagementSystem.BusServiceImplimentation.DriverServiceImplementation;

	
	@CrossOrigin(origins = "http://localhost:4200")  
	@RestController
	@RequestMapping("/Driver")
	public class DriverController {

		
		private DriverServiceImplementation driverService;

		public DriverController(DriverServiceImplementation driverService) {
			this.driverService = driverService;
		}

		
		
		@PostMapping("/saveDriver")
		public ResponseEntity<Driver> saveDriverDetails(@RequestBody Driver driver) {
			try {
				System.out.println("hii controller");
				return new ResponseEntity<Driver>(driverService.saveDriverDetails(driver), HttpStatus.CREATED);
			}
			catch(Exception e)
			{
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		/*@PostMapping("/save")
	    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver) {
	        try {
	            Driver savedDriver = driverService.saveDriver(driver);
	            return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }*/

		
		@GetMapping
		public ResponseEntity<List<Driver>> getDriverDetails(@RequestParam(required = false) String name) {
			
			try {
				
				List<Driver> driverList = driverService.getDriverDetailsFromDb(name);
				System.out.println("hello controller");

				if (driverList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				System.out.println("hello controler");
				return new ResponseEntity<>(driverList, HttpStatus.OK);  

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("{id}")
		public ResponseEntity<Driver> getDriverDetailsById(@PathVariable("id") int driverId) {
			Optional<Driver> driverData = driverService.getDriverDetailsById(driverId);

			if(driverData.isPresent())
			{
				//return new ResponseEntity<>(busService.getBusDetailsById(busId), HttpStatus.OK);
				return new ResponseEntity<>(driverData.get(),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("delete/{id}")	
		public ResponseEntity<String> deleteDriverById(@PathVariable("id")  int driverId)
		{
			Optional<Driver> driverData=driverService.getDriverDetailsById(driverId);

			try {
				if(driverData.isPresent())
				{
					driverService.deleteDriverDetailsById(driverId);
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

		
		@PutMapping("{driverId}")
		public ResponseEntity<Driver> updateDriverDetailsById(@PathVariable int driverId, @RequestBody Driver driverDetails){
			Optional<Driver> driverData=driverService.getDriverDetailsById(driverId);

			if(driverData.isPresent())
			{

				driverService.updateDriverDetailsById(driverData, driverDetails);
				return new ResponseEntity<>(driverService.updateDriverDetailsById(driverData,driverDetails ),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		
		
	}


