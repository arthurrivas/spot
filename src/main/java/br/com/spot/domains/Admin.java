package br.com.spot.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.spot.domains.enums.Profile;

@Entity
@PrimaryKeyJoinColumn(name="idAdmin")
public class Admin extends User {

	@OneToMany(mappedBy = "admin")
    private List<Location> createdLocations;

	public Admin(Integer id,String email, String password) {
		super(id, email, password);
		this.addProfiles(Profile.ADMIN);
	}
	
}
