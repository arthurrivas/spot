package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spot.domains.Client;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRespository;
	@Autowired
	BCryptPasswordEncoder pe;
	
	public void save(Client client) {
		clientRespository.save(client);
	}

	public Client fromCreateUserDTO(CreateUserDTO newUserDTO) {
		return new Client(null, newUserDTO.getEmail(), pe.encode(newUserDTO.getPassword()));
	}
	
	
	
}
