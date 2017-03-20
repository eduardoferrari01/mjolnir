package br.com.app.domain;

public class ComputerSystem {

	private String manufacturer;
	private String model;
	private String serialNumber;
	private Firmware firmware;
	private Baseboard baseboard;
	
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
	
	
}
