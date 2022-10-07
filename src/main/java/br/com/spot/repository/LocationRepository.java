package br.com.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	
	
	@Query(nativeQuery = true, value = "SELECT count(*) from location")
	public Long countAll();

}
