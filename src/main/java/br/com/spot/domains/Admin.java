package br.com.spot.domains;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idAdmin")
public class Admin extends User {

	
}
