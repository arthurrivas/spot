package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spot.domains.Address;
import br.com.spot.domains.dtos.LocationNAddressDTO;
import br.com.spot.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public Address fromLocationNAddressDTO(LocationNAddressDTO locAddDTO) {
		return new Address(
				null,
				locAddDTO.getNumberAddress(), 
				locAddDTO.getStreetAddress(),
				locAddDTO.getDistrictAddress(),
				locAddDTO.getCityAddress(),
				locAddDTO.getLatitudeAddress(),
				locAddDTO.getLongitudeAddress());
	}
}
