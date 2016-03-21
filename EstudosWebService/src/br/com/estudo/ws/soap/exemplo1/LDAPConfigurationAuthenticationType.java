package br.com.estudo.ws.soap.exemplo1;

public enum LDAPConfigurationAuthenticationType {
	SIM("simple"),

	COM("compost");

	private final String description;

	private LDAPConfigurationAuthenticationType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
