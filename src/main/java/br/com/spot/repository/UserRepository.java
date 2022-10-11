package br.com.spot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spot.domains.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findById(Integer id);

	User findByEmail(String email);

}
