package br.com.spot.domains;

import java.util.Date;

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
	
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name="id_client")	
	private Client client;
	
	@ManyToOne()
	@JoinColumn(name="id_location")
	private Location location;

	public LeaseRegistration() {
	}
	
	public LeaseRegistration(Integer id, Date date, Client client, Location location) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
