package br.com.spot.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spot.domains.enums.Profile;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@PrimaryKeyJoinColumn(name="idAdmin")
public class Admin extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "admin")
    private List<Location> createdLocations;
	
	public Admin() {
	}
	
	public Admin(Integer id,String email, String password) {
		super(id, email, password);
		this.addProfiles(Profile.ADMIN);
	}

	public void addLocation(Location location) {
		this.createdLocations.add(location);
	}
	
	public List<Location> getCreatedLocations() {
		return createdLocations;
	}

	public void setCreatedLocations(List<Location> createdLocations) {
		this.createdLocations = createdLocations;
	}
	
}
