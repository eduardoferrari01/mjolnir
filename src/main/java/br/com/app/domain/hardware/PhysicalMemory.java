package br.com.app.domain.hardware;

public class PhysicalMemory {

	private String bankLabel;
	private Long capacity;
	private Long clockSpeed;
	private String manufacturer;
	private String memoryType;
	
	public String getBankLabel() {
		return bankLabel;
	}
	public void setBankLabel(String bankLabel) {
		this.bankLabel = bankLabel;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public Long getClockSpeed() {
		return clockSpeed;
	}
	public void setClockSpeed(Long clockSpeed) {
		this.clockSpeed = clockSpeed;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMemoryType() {
		return memoryType;
	}
	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
}
