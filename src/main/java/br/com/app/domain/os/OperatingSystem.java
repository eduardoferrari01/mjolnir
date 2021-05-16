package br.com.app.domain.os;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperatingSystem {

	enum ProcessSort {
		CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME
	}
	
	@Id
	private String id;
	private String family;
	private String manufacturer;
	private Integer processId;
	private Integer processCount;
	private Integer threadCount;
	private Integer bitness;
	private Long systemUptime;
	private Long systemBootTime;
	private Boolean isElevated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Integer getProcessCount() {
		return processCount;
	}

	public void setProcessCount(Integer processCount) {
		this.processCount = processCount;
	}

	public Integer getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Integer threadCount) {
		this.threadCount = threadCount;
	}

	public Integer getBitness() {
		return bitness;
	}

	public void setBitness(Integer bitness) {
		this.bitness = bitness;
	}

	public Long getSystemUptime() {
		return systemUptime;
	}

	public void setSystemUptime(Long systemUptime) {
		this.systemUptime = systemUptime;
	}

	public Long getSystemBootTime() {
		return systemBootTime;
	}
	
	public void setSystemBootTime(Long systemBootTime) {
		this.systemBootTime = systemBootTime;
	}

	public Boolean getIsElevated() {
		return isElevated;
	}

	public void setIsElevated(Boolean isElevated) {
		this.isElevated = isElevated;
	}

	public LocalDateTime getBootTime() {
		return Instant.ofEpochSecond(getSystemBootTime())
			.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public Long getDayUptTime() {
		
		return TimeUnit.SECONDS.toDays(systemUptime);
	}
	
	public String getHourUpTime() {

		Long systemUptimeTemp = systemUptime;
		Long hour = TimeUnit.SECONDS.toHours(systemUptimeTemp);
		systemUptimeTemp -= TimeUnit.HOURS.toSeconds(hour);
		Long minute = TimeUnit.SECONDS.toMinutes(systemUptimeTemp);
		systemUptimeTemp -= TimeUnit.MINUTES.toSeconds(minute);
		Long second = systemUptimeTemp;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bitness == null) ? 0 : bitness.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isElevated == null) ? 0 : isElevated.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((processCount == null) ? 0 : processCount.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((systemBootTime == null) ? 0 : systemBootTime.hashCode());
		result = prime * result + ((systemUptime == null) ? 0 : systemUptime.hashCode());
		result = prime * result + ((threadCount == null) ? 0 : threadCount.hashCode());
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
		OperatingSystem other = (OperatingSystem) obj;
		if (bitness == null) {
			if (other.bitness != null)
				return false;
		} else if (!bitness.equals(other.bitness))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isElevated == null) {
			if (other.isElevated != null)
				return false;
		} else if (!isElevated.equals(other.isElevated))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (processCount == null) {
			if (other.processCount != null)
				return false;
		} else if (!processCount.equals(other.processCount))
			return false;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (systemBootTime == null) {
			if (other.systemBootTime != null)
				return false;
		} else if (!systemBootTime.equals(other.systemBootTime))
			return false;
		if (systemUptime == null) {
			if (other.systemUptime != null)
				return false;
		} else if (!systemUptime.equals(other.systemUptime))
			return false;
		if (threadCount == null) {
			if (other.threadCount != null)
				return false;
		} else if (!threadCount.equals(other.threadCount))
			return false;
		return true;
	}
}