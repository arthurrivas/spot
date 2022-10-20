package br.com.spot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Admin;
import br.com.spot.domains.Client;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.services.AdminService;
import br.com.spot.services.ClientService;
import br.com.spot.services.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	@Autowired
	ClientService clientService;
	
	@PostMapping(value = "/client")
	public ResponseEntity<?> createClient(@RequestBody CreateUserDTO newUserDTO){
		try {
			
			Client client = clientService.fromCreateUserDTO(newUserDTO);
			clientService.save(client);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(client);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
