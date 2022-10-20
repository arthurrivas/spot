package br.com.spot.domains;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spot.domains.enums.Profile;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@PrimaryKeyJoinColumn(name="idClient")
public class Client extends User{
	
	public Client() {
		super();
	}
	
	public Client(Integer id, String email, String password) {
		super(id,email,password);
		this.addProfiles(Profile.CLIENT);
	}
	
}
