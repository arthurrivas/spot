package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spot.domains.User;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.repository.UserRepository;
import br.com.spot.security.UserSS;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	public static UserSS authenticated(){
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
		} catch (Exception e) {
			return null;
		}
	}

	public User getById(Integer id) {
		return userRepository.findById(id).get();
	}

	public User fromCreateUserDTO(CreateUserDTO userDTO) {
		return new User(null, userDTO.getEmail(), pe.encode(userDTO.getPassword()));
	}
}
