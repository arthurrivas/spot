package br.com.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
