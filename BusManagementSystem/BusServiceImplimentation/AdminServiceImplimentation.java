package com.BusManagementSystem.BusServiceImplimentation;


	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.BusManagementSystem.Bus.Admin;
import com.BusManagementSystem.BusRepository.AdminRepository;

	@Service
	public class AdminServiceImplimentation {
		@Autowired
		private AdminRepository adminRepo;
		
		public void addadmin(Admin admin) {
			
			this.adminRepo.save(admin);
			
		}

		public Optional<Admin> getadminByEmail(String email) {
			
			return this.adminRepo.findByadminEmail(email);
			
		}


	}
