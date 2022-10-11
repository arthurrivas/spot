package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spot.domains.User;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.domains.enums.Profile;
import br.com.spot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

}
