package br.com.spot.domains.dtos;

public class CreateUserDTO {
	
	private String email;
	private String password;

	public CreateUserDTO() {
	}
	
	public CreateUserDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
