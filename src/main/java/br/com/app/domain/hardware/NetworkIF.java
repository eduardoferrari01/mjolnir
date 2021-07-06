package br.com.app.domain.hardware;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NetworkIF {

	@Id
	private String id;
	private List<Network> networks;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public List<Network> getNetworks() {
		
		if(networks != null) {
			return networks;
		}
		
		return Collections.emptyList();
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}
}