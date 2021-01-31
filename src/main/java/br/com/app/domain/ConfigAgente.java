package br.com.app.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigAgente implements Serializable {

	@Id
	private String hash;
	private String hostName;
	private Long tempoEspera = 3L;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Long getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(Long tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

}
