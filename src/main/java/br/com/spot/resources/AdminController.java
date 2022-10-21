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
import br.com.spot.domains.dtos.CreateUserDTO;
import br.com.spot.services.AdminService;
import br.com.spot.services.ClientService;
import br.com.spot.services.UserService;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping
	public ResponseEntity<?> getAdmins(){
		try {
			
			List<Admin> admins = adminService.findAll();
			
			return new ResponseEntity<>(HttpStatus.OK).ok(admins);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable(value = "id") Integer id ){
		try {
			
			Admin admin = adminService.getAdminById(id);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(admin);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}	
	}
	
	@PostMapping()
	public ResponseEntity<?> createAdmin(@RequestBody CreateUserDTO newUserDTO){
		try {
			
			Admin admin = adminService.fromCreateUserDTO(newUserDTO);
			adminService.save(admin);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(admin);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable(value = "id") Integer id, @RequestBody CreateUserDTO userDTO){	
		try {
			
			// Valida existencia de admin
			Admin admin = adminService.getAdminById(id);
			if(admin == null) return ResponseEntity.badRequest().build();
			
			Admin updatedAdmin = adminService.fromCreateUserDTO(userDTO);
			updatedAdmin.setId(id);
			
			adminService.save(updatedAdmin);
			
			
			return new ResponseEntity<>(HttpStatus.OK).ok(updatedAdmin);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAdminById(@PathVariable(value = "id")Integer id){
		
		try {
			
			adminService.deleteAdminById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
}
