package com.BusManagementSystem.BusRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusManagementSystem.Bus.Driver;


public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	List<Driver> findByNameContainingIgnoreCase(String name);

}