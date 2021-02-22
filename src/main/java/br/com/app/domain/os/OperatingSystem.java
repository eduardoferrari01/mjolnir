package br.com.app.domain.operatingsystem;

import java.util.List;

import br.com.app.domain.hardware.Process;

public class OperatingSystem {

	enum ProcessSort {
		CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME
	}

	private String family;

	private String manufacturer;

	private OperatingSystemVersion version;

	private FileSystem fileSystem;

	private List<Process> processes;

	private Integer processID;

	private Integer processCount;

	private Integer threadCount;

	private NetworkParams networkParams;

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

	public OperatingSystemVersion getVersion() {
		return version;
	}

	public void setVersion(OperatingSystemVersion version) {
		this.version = version;
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	public Integer getProcessID() {
		return processID;
	}

	public void setProcessID(Integer processID) {
		this.processID = processID;
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

	public NetworkParams getNetworkParams() {
		return networkParams;
	}

	public void setNetworkParams(NetworkParams networkParams) {
		this.networkParams = networkParams;
	}

}
