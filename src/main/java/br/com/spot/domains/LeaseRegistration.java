package br.com.spot.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LeaseRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name="id_client")	
	private Client client;
	
	@ManyToOne()
	@JoinColumn(name="id_location")
	private Location location;
	
	
	
}
