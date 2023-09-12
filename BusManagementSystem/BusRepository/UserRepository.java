package com.BusManagementSystem.BusRepository;


	
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.BusManagementSystem.Bus.User;

	


	@Repository
	public interface UserRepository extends JpaRepository<User, Long>{

		@Query(value = "SELECT * FROM User_table p WHERE p.bus_id = ?1",nativeQuery = true  )
		public List<User> findUsersByBusId(long busId);
	}


