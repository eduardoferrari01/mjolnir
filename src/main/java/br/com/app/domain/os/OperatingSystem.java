package br.com.app.domain.os;

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
}