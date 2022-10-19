package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.spot.domains.Admin;
import br.com.spot.domains.Location;
import br.com.spot.domains.dtos.LocationNAddressDTO;
import br.com.spot.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public void save(Location location) {
		locationRepository.save(location);
	}

	public Location getRandom() {
		Long qty = locationRepository.countAll();
	    
		System.out.println(qty);
		
		int idx = (int)(Math.random() * qty);
	    Page<Location> locationPage = locationRepository.findAll(PageRequest.of(idx, 1));
	    Location location = null;
	    
	    if (locationPage.hasContent()) {
	    	location = locationPage.getContent().get(0);
	    }
	    return location;
	}
	
	
	public Location fromLocationNAddressDTO(LocationNAddressDTO locAddDTO, Admin admin) {
		return new Location(null, locAddDTO.getTitleLocation(),locAddDTO.getDescriptionLocation(), admin);
	}


	
	
}
