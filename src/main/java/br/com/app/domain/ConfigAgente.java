package br.com.app.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.app.util.GenerateHash;

@Document
public class ConfigAgente implements Serializable{

	private static final long serialVersionUID = 2574819657534120194L;
	@Id
	private String hash;
	private String hostName;
	private Long tempoEspera = 3L;

	public static class Builder {
		
		private String hostName;
		private String hash;
		private Long tempoEspera;
		
		public Builder(String hostName) {
			this.hostName = hostName;
			this.hash = new GenerateHash("SHA-256").gerar(hostName);
			this.tempoEspera = 3L;
		}
		
		public Builder tempoEspera(Long tempoEspera) {
			
			this.tempoEspera = tempoEspera;
			return this;
		}
		
		public ConfigAgente build() {
			return new ConfigAgente(this);
		}
	}
	
	private ConfigAgente(Builder builder) {
		this.hostName = builder.hostName;
		this.hash = builder.hash;
		this.tempoEspera = builder.tempoEspera;
	}
	
	public ConfigAgente() {}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((tempoEspera == null) ? 0 : tempoEspera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigAgente other = (ConfigAgente) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		if (tempoEspera == null) {
			if (other.tempoEspera != null)
				return false;
		} else if (!tempoEspera.equals(other.tempoEspera))
			return false;
		return true;
	}
}
