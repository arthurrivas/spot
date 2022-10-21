package br.com.spot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Admin;
import br.com.spot.domains.Client;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.services.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<?> getClients(){
		try {
			
			List<Client> clients = clientService.findAll();
			
			return new ResponseEntity<>(HttpStatus.OK).ok(clients);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getClientById(@PathVariable(value = "id") Integer id ){
		try {
			
			Client client = clientService.getClientById(id);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(client);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}	
	}
	
	@PostMapping()
	public ResponseEntity<?> createClient(@RequestBody CreateUserDTO newUserDTO){
		try {
			
			Client client = clientService.fromCreateUserDTO(newUserDTO);
			clientService.save(client);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(client);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateClient(@PathVariable(value = "id") Integer id, @RequestBody CreateUserDTO userDTO){	
		try {
			Client client = clientService.fromCreateUserDTO(userDTO);
			client.setId(id);
			clientService.save(client);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(client);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAdminById(@PathVariable(value = "id")Integer id){
		try {
			
			clientService.deleteAdminById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
