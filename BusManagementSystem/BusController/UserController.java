package com.BusManagementSystem.BusController;



	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.Optional;
	import java.util.Random;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagementSystem.Bus.Bus;
import com.BusManagementSystem.Bus.User;
import com.BusManagementSystem.BusRepository.BusRepository;
import com.BusManagementSystem.BusServiceImplimentation.BusServiceImplementation;
import com.BusManagementSystem.BusServiceImplimentation.UserServiceImplementation;

	


	// many comments on one emp
	//many user book one rest

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/users")
	public class UserController {

		//open postm
		@Autowired
		private UserServiceImplementation userServiceImplementation;
		
		
		
		public UserController(UserServiceImplementation userServiceImplementation)
		{
		this.userServiceImplementation = userServiceImplementation;
		}

		
		
		@Autowired
		private BusRepository busRepo;
		
		
			@PostMapping("/{busId}")
			public ResponseEntity<Map<String,String>> addBooking(@PathVariable("busId") int busId,@RequestBody User user)
			{
			
					User obj=new User();
					Random rand = new Random();
					obj.setUserEmail(user.getUserEmail());
					int userId=rand.nextInt(11111);
					obj.setUserID(userId);
					obj.setUserName(user.getUserName());
					obj.setNoOfSeats(user.getNoOfSeats());
					obj.setDate(user.getDate());
					obj.setBusDetails(this.busRepo.findById( busId).get());
					this.userServiceImplementation.addUser(obj);
					Map<String,String> response=new HashMap<String,String>();
					response.put("status", "success");
					response.put("message", "Your Booking is Confirmed!!");
				
						return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
				
			}
			
			@GetMapping("/{busId}")
			public List<User> getUsersByBusId(@PathVariable long busId)
			{
				List<User> userList = new ArrayList<User>();
				userList = this.userServiceImplementation.findBookedUsersByBusId(busId);

				return  userList;

			}
//			@GetMapping
//			public ResponseEntity<List<Bus>> getAllBus(@RequestParam(required = false) String name) {
//				try {
//					List <Bus> busList = userServiceImplementation.getBusFromDb(name);
//					
//					if (busList.isEmpty()) 
//					{
//						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//					}
//
//					return new ResponseEntity<>(busList, HttpStatus.OK);  
//				
//				} catch (Exception e) {
//					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//			}
			@GetMapping("/userbyId/{id}")
			
			public ResponseEntity<User> getUserById(@PathVariable("id")  int userId){
				System.out.println(userId);
				Optional<User> user = userServiceImplementation.getUserById(userId);
				
				if(user.isPresent())
				{
					return new ResponseEntity<>(user.get(),HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
			@DeleteMapping("/deletebyId/{id}")	
			public ResponseEntity<String> deleteUserById(@PathVariable("id")  int userId)
			{
				Optional<User> userData=userServiceImplementation.getUserById(userId);

				try {
					if(userData.isPresent())
					{
						userServiceImplementation.deleteUserById(userId);
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

	}




