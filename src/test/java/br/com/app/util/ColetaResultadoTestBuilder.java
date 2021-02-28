package br.com.app.util;

import br.com.app.domain.ColetaResultado;

public class ColetaResultadoTestBuilder {

	private String id;
	private String json;
	
	public ColetaResultadoTestBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public ColetaResultadoTestBuilder setJson(String json) {
		
		this.json = json;
		return this;
	}
	
	public ColetaResultado builder() {
	
		ColetaResultado coletaResultado = new ColetaResultado();
		coletaResultado.setId("4aa6c0e7255c3b89987960d9097b40448079b48e0b51aa3160c486b2da7ff1cd");
		
		if (id != null) {

			coletaResultado.setId(this.id);
		}
		
		if(json != null) {
			
			coletaResultado.setJson(this.json);
		}
		
		return coletaResultado;
	}
}
