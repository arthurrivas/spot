package br.com.spot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spot.domains.Admin;
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

	public List<Client> findAll() {

		List<Client> clients = clientRespository.findAll();
		
		return clients;
	}

	public Client getClientById(Integer id) {

		Client client = clientRespository.getReferenceById(id);
		
		return client;
	}

	public void deleteAdminById(Integer id) {
		
		clientRespository.deleteById(id)	;
	}
	
	
	
}
