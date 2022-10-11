package br.com.spot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Address;
import br.com.spot.domains.Location;
import br.com.spot.domains.dtos.LocationNAddressDTO;
import br.com.spot.services.AddressService;
import br.com.spot.services.LocationService;

@RestController
@RequestMapping(value = "location")
public class LocationResource {
	
	@Autowired
	LocationService locationService;

	@Autowired
	AddressService addressService;
	
	/*
	* retorna location aleatorio  
	*/	
	@GetMapping(value = "/random")
	public ResponseEntity<?> getRandomLocation(){
		
//		locationService.getRandom();
			
		System.out.println("Opa");
		return null;
	}
	
	
	@PostMapping
	public ResponseEntity<?> createLocation(@RequestBody LocationNAddressDTO locAddDTO){
		try {
			Location location = locationService.fromLocationNAddressDTO(locAddDTO, null);
			Address address = addressService.fromLocationNAddressDTO(locAddDTO);
			
			location.setAddress(address);
			
			locationService.save(location);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(location);
		} catch (Exception e) {

			return ResponseEntity.noContent().build();
		}
		
	}
	
}




















