package br.com.app.test.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.app.domain.ColetaResultado;
import br.com.app.util.ObjectMapperCustomized;

public class ColetaResultadoTestDataBuilder {

	private String id;
	private String json;
	
	public ColetaResultadoTestDataBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public ColetaResultadoTestDataBuilder setJson(String json) {
		
		this.json = json;
		return this;
	}
	
	public String builderForJson()  {
		
		try {
			ColetaResultado coletaResultado = builder();
			ObjectMapper objectMapper = new ObjectMapperCustomized().create();
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coletaResultado);
		} catch (JsonProcessingException e) {
			
			return "";
		}
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
