package br.com.app.domain;


import java.util.List;


public class OperatingSystem {

	 
    enum ProcessSort {
        CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME
    }

    private String family;

   
    private String manufacturer;

    
    private OperatingSystemVersion version;

    private FileSystem fileSystem;

    
    private List<OSProcess> processes;

    private Integer processId;

    
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


	public List<OSProcess> getProcesses() {
		return processes;
	}


	public void setProcesses(List<OSProcess> processes) {
		this.processes = processes;
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


	public NetworkParams getNetworkParams() {
		return networkParams;
	}

	public void setNetworkParams(NetworkParams networkParams) {
		this.networkParams = networkParams;
	}
    
}
