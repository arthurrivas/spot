package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		return null;
//		int idx = (int)(Math.random() * qty);
//	    Page<Question> questionPage = questionRepository.findAll(new PageRequest(idx, 1));
//	    Question q = null;
//	    if (questionPage.hasContent()) {
//	        q = questionPage.getContent().get(0);
//	    }
//	    return q;
	}
	
	
	public Location fromLocationNAddressDTO(LocationNAddressDTO locAddDTO, Admin admin) {
		return new Location(null, locAddDTO.getTitleLocation(),locAddDTO.getDescriptionLocation(), admin);
	}


	
	
}
