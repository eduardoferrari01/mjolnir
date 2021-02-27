package br.com.app.domain.os;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class OSProcess {
	
	private String name;
	private String path;
	private String commandLine;
	private String currentWorkingDirectory;
	private String user;
	private String userID;
	private String group;
	private String groupID;
	private State state;
	private Integer processID;
	private Integer parentProcessID;
	private Integer threadCount;
	private Integer priority;
	private Long virtualSize;
	private Long residentSetSize;
	private Long kernelTime;
	private Long userTime;
	private Long upTime;
	private Long startTime;
	private Long bytesRead;
	private Long bytesWritten;
	private Long openFiles;
	private Double processCpuLoadCumulative;
	private Integer bitness;
	private Long affinityMask;
	private Boolean updateAttributes;
	private List<OSThread> threadDetails;
	private Long minorFaults;
	private Long majorFaults;
	
	public enum State {
		NEW, RUNNING, SLEEPING, WAITING, ZOMBIE, STOPPED, OTHER
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(String commandLine) {
		this.commandLine = commandLine;
	}

	public String getCurrentWorkingDirectory() {
		return currentWorkingDirectory;
	}

	public void setCurrentWorkingDirectory(String currentWorkingDirectory) {
		this.currentWorkingDirectory = currentWorkingDirectory;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getProcessID() {
		return processID;
	}

	public void setProcessID(Integer processID) {
		this.processID = processID;
	}

	public Integer getParentProcessID() {
		return parentProcessID;
	}

	public void setParentProcessID(Integer parentProcessID) {
		this.parentProcessID = parentProcessID;
	}

	public Integer getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Integer threadCount) {
		this.threadCount = threadCount;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getVirtualSize() {
		return virtualSize;
	}

	public void setVirtualSize(Long virtualSize) {
		this.virtualSize = virtualSize;
	}

	public Long getResidentSetSize() {
		return residentSetSize;
	}

	public void setResidentSetSize(Long residentSetSize) {
		this.residentSetSize = residentSetSize;
	}

	public Long getKernelTime() {
		return kernelTime;
	}

	public void setKernelTime(Long kernelTime) {
		this.kernelTime = kernelTime;
	}

	public Long getUserTime() {
		return userTime;
	}

	public void setUserTime(Long userTime) {
		this.userTime = userTime;
	}

	public Long getUpTime() {
		return upTime;
	}

	public void setUpTime(Long upTime) {
		this.upTime = upTime;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(Long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public Long getBytesWritten() {
		return bytesWritten;
	}

	public void setBytesWritten(Long bytesWritten) {
		this.bytesWritten = bytesWritten;
	}

	public Long getOpenFiles() {
		return openFiles;
	}

	public void setOpenFiles(Long openFiles) {
		this.openFiles = openFiles;
	}

	public Double getProcessCpuLoadCumulative() {
		return processCpuLoadCumulative;
	}

	public void setProcessCpuLoadCumulative(Double processCpuLoadCumulative) {
		this.processCpuLoadCumulative = processCpuLoadCumulative;
	}

	public Integer getBitness() {
		return bitness;
	}

	public void setBitness(Integer bitness) {
		this.bitness = bitness;
	}

	public Long getAffinityMask() {
		return affinityMask;
	}

	public void setAffinityMask(Long affinityMask) {
		this.affinityMask = affinityMask;
	}

	public Boolean getUpdateAttributes() {
		return updateAttributes;
	}

	public void setUpdateAttributes(Boolean updateAttributes) {
		this.updateAttributes = updateAttributes;
	}

	public List<OSThread> getThreadDetails() {
		return threadDetails;
	}

	public void setThreadDetails(List<OSThread> threadDetails) {
		this.threadDetails = threadDetails;
	}

	public Long getMinorFaults() {
		return minorFaults;
	}

	public void setMinorFaults(Long minorFaults) {
		this.minorFaults = minorFaults;
	}

	public Long getMajorFaults() {
		return majorFaults;
	}

	public void setMajorFaults(Long majorFaults) {
		this.majorFaults = majorFaults;
	}
}
