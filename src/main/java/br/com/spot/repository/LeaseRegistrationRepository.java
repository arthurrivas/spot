package br.com.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.LeaseRegistration;

@Repository
public interface LeaseRegistrationRepository extends JpaRepository<LeaseRegistration, Integer>{

}
