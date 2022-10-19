package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.spot.repository.UserRepository;
import br.com.spot.security.UserSS;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public static UserSS authenticated(){
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
		} catch (Exception e) {
			return null;
		}
	}
}
