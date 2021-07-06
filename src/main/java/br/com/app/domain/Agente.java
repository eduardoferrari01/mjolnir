package br.com.app.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.app.util.GenerateHash;

@Document
public class Agente implements Serializable{

	private static final long serialVersionUID = 2574819657534120194L;
	@Id
	private String hash;
	private String hostName;
	private Long tempoEspera = 3L;
	private String sector = "";
	private String alias = "";
	
	public static class Builder {
		
		private String hostName;
		private String hash;
		private Long tempoEspera;
		private String sector = "";
		private String alias = "";
		
		public Builder(String hostName) {
			this.hostName = hostName;
			this.hash = new GenerateHash("SHA-256").gerar(hostName);
			this.tempoEspera = 3L;
			this.sector = "";
			this.alias = "";
		}
		
		public Builder tempoEspera(Long tempoEspera) {
			
			this.tempoEspera = tempoEspera;
			return this;
		}
		
		public Builder sector(String sector) {
			
			this.sector = sector;
			return this;
		}
		
		public Builder alias(String alias) {
			
			this.alias = alias;
			return this;
		}
		
		public Agente build() {
			return new Agente(this);
		}
	}
	
	private Agente(Builder builder) {
		this.hostName = builder.hostName;
		this.hash = builder.hash;
		this.tempoEspera = builder.tempoEspera;
		this.sector = builder.sector;
		this.alias = builder.alias;
	}
	
	public Agente() {}
	
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

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
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
		Agente other = (Agente) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		return true;
	}

}