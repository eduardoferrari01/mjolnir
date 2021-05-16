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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bitness == null) ? 0 : bitness.hashCode());
		result = prime * result + ((bootTime == null) ? 0 : bootTime.hashCode());
		result = prime * result + ((dayUptTime == null) ? 0 : dayUptTime.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((hourUpTime == null) ? 0 : hourUpTime.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((versionInfo == null) ? 0 : versionInfo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperatingSystemInformation other = (OperatingSystemInformation) obj;
		if (bitness == null) {
			if (other.bitness != null)
				return false;
		} else if (!bitness.equals(other.bitness))
			return false;
		if (bootTime == null) {
			if (other.bootTime != null)
				return false;
		} else if (!bootTime.equals(other.bootTime))
			return false;
		if (dayUptTime == null) {
			if (other.dayUptTime != null)
				return false;
		} else if (!dayUptTime.equals(other.dayUptTime))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (hourUpTime == null) {
			if (other.hourUpTime != null)
				return false;
		} else if (!hourUpTime.equals(other.hourUpTime))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (versionInfo == null) {
			if (other.versionInfo != null)
				return false;
		} else if (!versionInfo.equals(other.versionInfo))
			return false;
		return true;
	}
}
