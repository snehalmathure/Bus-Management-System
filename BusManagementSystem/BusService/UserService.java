package com.BusManagementSystem.BusService;


	

	import java.util.List;
import java.util.Optional;

import com.BusManagementSystem.Bus.Bus;
import com.BusManagementSystem.Bus.User;



	
	public interface UserService {

		public void addUser(User obj);
		public List<User> findBookedUsersByBusId(long busId);
		Optional<User> getUserById(int userId);
	}


