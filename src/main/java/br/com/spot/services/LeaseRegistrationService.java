package br.com.spot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spot.domains.LeaseRegistration;
import br.com.spot.repository.LeaseRegistrationRepository;

@Service
public class LeaseRegistrationService {

	@Autowired
	LeaseRegistrationRepository lsRepository;
	
	public void save(LeaseRegistration leaseRegistration) {
		lsRepository.save(leaseRegistration);
	}
}
