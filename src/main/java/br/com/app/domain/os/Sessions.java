package br.com.app.domain.os;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 

@Document
public class Sessions {

	@Id
	private String id;
	private List<OSSession> osSession;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<OSSession> getOsSession() {
		return osSession;
	}
	public void setOsSession(List<OSSession> osSession) {
		this.osSession = osSession;
	}
	
	
}
