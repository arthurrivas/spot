package br.com.spot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Admin;
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.services.AdminService;
import br.com.spot.services.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	
	@PostMapping(value = "/admin")
	public ResponseEntity<?> createAdmin(@RequestBody CreateUserDTO newUserDTO){
		try {
			
			Admin admin = adminService.fromCreateUserDTO(newUserDTO);
			adminService.save(admin);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(admin);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
