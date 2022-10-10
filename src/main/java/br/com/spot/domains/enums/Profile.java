package br.com.spot.domains.enums;

public enum Profile {

	ADMIN(1, "ROLE_ADMIM"), 
	CLIENT(2, "ROLE_CLIENT");

	private Integer codProfile;
	private String descriptionProfile;

	Profile(Integer i, String description) {
		this.codProfile = i;
		this.descriptionProfile = description;
	}

	public Integer getCodProfile() {
		return codProfile;
	}

	public void setCodProfile(Integer codPerfil) {
		this.codProfile = codPerfil;
	}

	public String getDescriptionProfile() {
		return descriptionProfile;
	}

	public void setDescriptionProfile(String descriptionProfile) {
		this.descriptionProfile = descriptionProfile;
	}
	

	public static Profile toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCodProfile())) {
				return x;
			}
		}
		return null;
	}

}