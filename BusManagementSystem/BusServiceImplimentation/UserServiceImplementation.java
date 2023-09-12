package com.BusManagementSystem.BusServiceImplimentation;


	

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.BusManagementSystem.Bus.Bus;
import com.BusManagementSystem.Bus.User;
import com.BusManagementSystem.BusRepository.BusRepository;
import com.BusManagementSystem.BusRepository.UserRepository;
import com.BusManagementSystem.BusService.UserService;

	

	@Service
	public class UserServiceImplementation implements UserService {
		
		@Autowired
		private UserRepository userRepo;
		
		

		public UserServiceImplementation(UserRepository userRepo) {
			this.userRepo = userRepo;
		}

		public void addUser(User obj) {
			
			this.userRepo.save(obj);
		}
		
		public List<User> findBookedUsersByBusId(long busId) {
			
			return this.userRepo.findUsersByBusId(busId);
		}
		
		
		public Optional<User> getUserById(int userId) { 
			Optional<User> user=userRepo.findById((long) userId);
			return user;
		}
		
		public void deleteUserById(int userId) {

			userRepo.deleteById((long) userId);
		}

		

	}


