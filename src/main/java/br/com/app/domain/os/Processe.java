package br.com.app.domain.os;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Processe {

	@Id
	private String id;
	private List<OSProcess> osProcess;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<OSProcess> getOsProcess() {
		return osProcess;
	}
	public void setOsProcess(List<OSProcess> osProcess) {
		this.osProcess = osProcess;
	}
}
