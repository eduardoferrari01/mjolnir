package br.com.app.domain.os;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Service {

	@Id
	private String id;
	private List<OSService> osService;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<OSService> getOsService() {
		return osService;
	}
	public void setOsService(List<OSService> osService) {
		this.osService = osService;
	}

}