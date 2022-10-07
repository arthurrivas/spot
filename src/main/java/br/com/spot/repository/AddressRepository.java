package br.com.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
