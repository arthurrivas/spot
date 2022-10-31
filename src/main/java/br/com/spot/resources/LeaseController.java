package br.com.spot.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spot.domains.Client;
import br.com.spot.domains.LeaseRegistration;
import br.com.spot.domains.Location;
import br.com.spot.security.UserSS;
import br.com.spot.services.ClientService;
import br.com.spot.services.LeaseRegistrationService;
import br.com.spot.services.LocationService;
import br.com.spot.services.UserService;

@RestController
@RequestMapping(value = "lease")
public class LeaseController {
	
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	LeaseRegistrationService leaseService;
	
	@PostMapping
	public ResponseEntity<?> createLeaseRegistration(@RequestParam(value =  "id-location") Integer id){
		try {
			
			UserSS ss = UserService.authenticated();
			
			if (ss != null && ss.getId() != null) {
				
				Client client = clientService.getClientById(ss.getId());
				
				Location local = locationService.getLocationById(id);
				if (local == null) return ResponseEntity.badRequest().build();
				
				
				LeaseRegistration reg = new LeaseRegistration(null, new Date(), client, local);
				leaseService.save(reg);
				
				return new ResponseEntity<>(HttpStatus.OK).ok(reg);
				
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
