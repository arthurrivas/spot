package br.com.spot.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Admin;
import br.com.spot.domains.Client;
import br.com.spot.domains.User;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.security.UserSS;
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
	
	@GetMapping(value = "/current")
	public ResponseEntity<?> getCurrentUser(){
		try {
			UserSS ss = UserService.authenticated();
			if (ss != null && ss.getId() != null) {
				
				User user = userService.getById(ss.getId());
				
				if (user != null)
					return new ResponseEntity<>(HttpStatus.OK).ok(user);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.noContent().build(); 
		}
	}
	
	
	@PostMapping()
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO newUserDTO, @RequestParam(value = "cod-profile") Integer id ){
		try {
			User user = new User();
			
			switch (id) {
			case 1: // admin	
				user = adminService.fromCreateUserDTO(newUserDTO);
				adminService.save((Admin) user);				
			case 2: // client	
				user = adminService.fromCreateUserDTO(newUserDTO);
				clientService.save((Client) user);					
			default:
				break;
			}
			return new ResponseEntity<>(HttpStatus.OK).ok(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@Valid @PathVariable(value = "id") Integer id, @RequestBody CreateUserDTO userDTO){	
		try {
			// Valida existencia de user
			User user = userService.getById(id);
			if(user == null) return ResponseEntity.badRequest().build();
			
			User updatedUser = userService.fromCreateUserDTO(userDTO);
			updatedUser.setId(id);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(updatedUser);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	
	
}













