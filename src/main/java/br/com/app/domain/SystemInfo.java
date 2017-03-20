package br.com.app.domain;

import org.springframework.data.annotation.Id;

public class SystemInfo {

	@Id
	private String id; 
	private OperatingSystem os ;
	 private HardwareAbstractionLayer hardware;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OperatingSystem getOs() {
		return os;
	}
	public void setOs(OperatingSystem os) {
		this.os = os;
	}
	public HardwareAbstractionLayer getHardware() {
		return hardware;
	}
	public void setHardware(HardwareAbstractionLayer hardware) {
		this.hardware = hardware;
	}
	 
	 
}
