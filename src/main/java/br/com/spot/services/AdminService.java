package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spot.domains.Admin;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	public void save(Admin admin) {
		adminRepository.save(admin);
	}
	
	
	public Admin fromCreateUserDTO(CreateUserDTO user) {
		return new Admin(null, user.getEmail(), pe.encode(user.getPassword()));
	}
	
		
}
