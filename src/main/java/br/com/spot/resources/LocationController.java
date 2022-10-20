package br.com.spot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Address;
import br.com.spot.domains.Admin;
import br.com.spot.domains.Location;
import br.com.spot.domains.dtos.LocationNAddressDTO;
import br.com.spot.security.UserSS;
import br.com.spot.services.AddressService;
import br.com.spot.services.AdminService;
import br.com.spot.services.LocationService;
import br.com.spot.services.UserService;

@RestController
@RequestMapping(value = "location")
public class LocationResource {
	
	@Autowired
	LocationService locationService;

	@Autowired
	AddressService addressService;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(value = "/random")
	public ResponseEntity<?> getRandomLocation(){
		try {
			Location location = locationService.getRandom();
			
			return new ResponseEntity<>(HttpStatus.OK).ok(location);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> createLocation(@RequestBody LocationNAddressDTO locAddDTO){
		try {
			
			UserSS ss = UserService.authenticated();
			
			if (ss != null && ss.getId() != null) {
				
				Admin admin = adminService.getAdminById(ss.getId());
				
				Location location = locationService.fromLocationNAddressDTO(locAddDTO, null);
				Address address = addressService.fromLocationNAddressDTO(locAddDTO);
				
				location.setAddress(address);
				location.setAdmin(admin);
				
				locationService.save(location);
				
				return new ResponseEntity<>(HttpStatus.OK).ok(location);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
			
		} catch (Exception e) {

			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getLocationsByAdminId(@PathVariable(value = "id") Integer id){
		try {

			Admin admin = adminService.getAdminById(id);
			
			List<Location> locations = admin.getCreatedLocations();
			
			return new ResponseEntity<>(HttpStatus.OK).ok(locations);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}




















