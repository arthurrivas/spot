package br.com.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
}
