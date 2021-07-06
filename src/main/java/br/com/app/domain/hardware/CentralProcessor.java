package br.com.app.domain.hardware;

import java.util.List;

public class CentralProcessor {
	
	private String id;
	private Long maxFreq;
	private List<Long> currentFreq;
	private Long contextSwitches;
	private Long interrupts;
	private List<Long> systemCpuLoadTicks;
	private Long[][] processorCpuLoadTicks;
	private Integer physicalPackageCount;
	private Integer physicalProcessorCount;
	private Integer logicalProcessorCount;
	private List<LogicalProcessors> logicalProcessors;
	private ProcessorIdentifier processorIdentifier;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMaxFreq() {
		return maxFreq;
	}

	public void setMaxFreq(Long maxFreq) {
		this.maxFreq = maxFreq;
	}

	public List<Long> getCurrentFreq() {
		return currentFreq;
	}

	public void setCurrentFreq(List<Long> currentFreq) {
		this.currentFreq = currentFreq;
	}

	public Long getContextSwitches() {
		return contextSwitches;
	}

	public void setContextSwitches(Long contextSwitches) {
		this.contextSwitches = contextSwitches;
	}

	public Long getInterrupts() {
		return interrupts;
	}

	public void setInterrupts(Long interrupts) {
		this.interrupts = interrupts;
	}

	public List<Long> getSystemCpuLoadTicks() {
		return systemCpuLoadTicks;
	}

	public void setSystemCpuLoadTicks(List<Long> systemCpuLoadTicks) {
		this.systemCpuLoadTicks = systemCpuLoadTicks;
	}

	public Long[][] getProcessorCpuLoadTicks() {
		return processorCpuLoadTicks;
	}

	public void setProcessorCpuLoadTicks(Long[][] processorCpuLoadTicks) {
		this.processorCpuLoadTicks = processorCpuLoadTicks;
	}

	public Integer getPhysicalPackageCount() {
		return physicalPackageCount;
	}

	public void setPhysicalPackageCount(Integer physicalPackageCount) {
		this.physicalPackageCount = physicalPackageCount;
	}

	public Integer getPhysicalProcessorCount() {
		return physicalProcessorCount;
	}

	public void setPhysicalProcessorCount(Integer physicalProcessorCount) {
		this.physicalProcessorCount = physicalProcessorCount;
	}

	public Integer getLogicalProcessorCount() {
		return logicalProcessorCount;
	}

	public void setLogicalProcessorCount(Integer logicalProcessorCount) {
		this.logicalProcessorCount = logicalProcessorCount;
	}

	public List<LogicalProcessors> getLogicalProcessors() {
		return logicalProcessors;
	}

	public void setLogicalProcessors(List<LogicalProcessors> logicalProcessors) {
		this.logicalProcessors = logicalProcessors;
	}

	public ProcessorIdentifier getProcessorIdentifier() {
		return processorIdentifier;
	}

	public void setProcessorIdentifier(ProcessorIdentifier processorIdentifier) {
		this.processorIdentifier = processorIdentifier;
	}

}
