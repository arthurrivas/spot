package br.com.spot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> createUser(@RequestBody CreateUserDTO newUserDTO, @PathVariable(value = "profile") Integer id){
		try {
			
			
			
			return null;
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
