package br.com.app.domain.os;

import br.com.app.domain.os.OSProcess.State;

public class OSThread {

	private Integer threadId;
	private String name;
	private State state;
	private Double threadCpuLoadCumulative;
	private Integer owningProcessId;
	private Long startMemoryAddress;
	private Long contextSwitches;
	private Long minorFaults;
	private Long majorFaults;
	private Long kernelTime;
	private Long userTime;
	private Long upTime;
	private Long startTime;
	private Integer priority;
	private Boolean updateAttributes;

	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getThreadCpuLoadCumulative() {
		return threadCpuLoadCumulative;
	}

	public void setThreadCpuLoadCumulative(Double threadCpuLoadCumulative) {
		this.threadCpuLoadCumulative = threadCpuLoadCumulative;
	}

	public Integer getOwningProcessId() {
		return owningProcessId;
	}

	public void setOwningProcessId(Integer owningProcessId) {
		this.owningProcessId = owningProcessId;
	}

	public Long getStartMemoryAddress() {
		return startMemoryAddress;
	}

	public void setStartMemoryAddress(Long startMemoryAddress) {
		this.startMemoryAddress = startMemoryAddress;
	}

	public Long getContextSwitches() {
		return contextSwitches;
	}

	public void setContextSwitches(Long contextSwitches) {
		this.contextSwitches = contextSwitches;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Boolean getUpdateAttributes() {
		return updateAttributes;
	}

	public void setUpdateAttributes(Boolean updateAttributes) {
		this.updateAttributes = updateAttributes;
	}
}
