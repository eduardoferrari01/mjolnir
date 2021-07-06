package br.com.app.domain.hardware;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PowerSources {

	@Id
	private String id;
	private List<PowerSource> powerSources;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<PowerSource> getPowerSources() {
		return powerSources;
	}
	public void setPowerSources(List<PowerSource> powerSources) {
		this.powerSources = powerSources;
	}
}
