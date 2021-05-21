package br.com.app.dto.os;

import java.time.LocalDateTime;

public class OperatingSystemInformation {

	private String versionInfo;
	private String family;
	private String manufacturer;
	private Integer bitness;
	private LocalDateTime bootTime;
	private Long dayUptTime;
	private String hourUpTime;
	
	public String getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getBitness() {
		return bitness;
	}
	public void setBitness(Integer bitness) {
		this.bitness = bitness;
	}
 
	public LocalDateTime getBootTime() {
		return bootTime;
	}
	public void setBootTime(LocalDateTime systemBootTime) {
		this.bootTime = systemBootTime;
	}
	public Long getDayUptTime() {
		return dayUptTime;
	}
	public void setDayUptTime(Long dayUptTime) {
		this.dayUptTime = dayUptTime;
	}
	public String getHourUpTime() {
		return hourUpTime;
	}
	public void setHourUpTime(String hourUpTime) {
		this.hourUpTime = hourUpTime;
	}
	
}
