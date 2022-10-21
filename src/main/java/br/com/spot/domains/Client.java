package br.com.spot.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spot.domains.enums.Profile;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@PrimaryKeyJoinColumn(name="idClient")
public class Client extends User{
	
	@OneToMany(mappedBy = "client")
	private List<LeaseRegistration> leaseRegistrations;
	
	public Client() {
		super();
	}
	
	public Client(Integer id, String email, String password) {
		super(id,email,password);
		this.addProfiles(Profile.CLIENT);
	}

	public void addLeaseRegistration(LeaseRegistration leaseRegistration) {
		this.leaseRegistrations.add(leaseRegistration);
	}
	
	public List<LeaseRegistration> getLeaseRegistrations() {
		return leaseRegistrations;
	}

	public void setLeaseRegistrations(List<LeaseRegistration> leaseRegistrations) {
		this.leaseRegistrations = leaseRegistrations;
	}
	
	
	
}
