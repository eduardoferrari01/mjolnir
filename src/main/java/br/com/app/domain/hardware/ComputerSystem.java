package br.com.app.domain.hardware;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ComputerSystem {

	@Id
	private String id;
	private String manufacturer;
	private String model;
	private String serialNumber;
	private Firmware firmware;
	private Baseboard baseboard;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Firmware getFirmware() {
		return firmware;
	}
	public void setFirmware(Firmware firmware) {
		this.firmware = firmware;
	}
	public Baseboard getBaseboard() {
		return baseboard;
	}
	public void setBaseboard(Baseboard baseboard) {
		this.baseboard = baseboard;
	}
	
	@Override
	public String toString() {
		return "ComputerSystem [manufacturer=" + manufacturer + ", model=" + model + ", serialNumber=" + serialNumber
				+ ", firmware=" + firmware + ", baseboard=" + baseboard + "]";
	}
	
}
