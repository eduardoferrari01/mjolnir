package br.com.app.domain;

import java.util.List;

public class Processor {

	 enum TickType {
        USER(0),
        NICE(1),
        SYSTEM(2),
        IDLE(3),
        IOWAIT(4),
        IRQ(5),
        SOFTIRQ(6);

        private int index;

        TickType(int value) {
            this.index = value;
        }

        public int getIndex() {
            return index;
        }
    }
	
    private String name;
    private Integer physicalPackageCount;
    private Integer physicalProcessorCount;
    private Integer logicalProcessorCount;
    private String vendor;
    private Long vendorFreq;
    private String processorID;
    private String identifier;
    private Boolean isCpu64bit;
    private String family;
    private String model;
    private String stepping;
    private  Double systemCpuLoadBetweenTicks;
    private List<Long> systemCpuLoadTicks;
    private Double systemCpuLoad;
    private Double systemLoadAverage;
    private List<Double> systemLoadAverages;
    private List <Double> processorCpuLoadBetweenTicks;
    Long[][] processorCpuLoadTicks;
    private Long systemUptime;
    private Long contextSwitches;
    private Long interrupts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Long getVendorFreq() {
		return vendorFreq;
	}
	public void setVendorFreq(Long vendorFreq) {
		this.vendorFreq = vendorFreq;
	}
	public String getProcessorID() {
		return processorID;
	}
	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Boolean getIsCpu64bit() {
		return isCpu64bit;
	}
	public void setIsCpu64bit(Boolean isCpu64bit) {
		this.isCpu64bit = isCpu64bit;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStepping() {
		return stepping;
	}
	public void setStepping(String stepping) {
		this.stepping = stepping;
	}
	public Double getSystemCpuLoadBetweenTicks() {
		return systemCpuLoadBetweenTicks;
	}
	public void setSystemCpuLoadBetweenTicks(Double systemCpuLoadBetweenTicks) {
		this.systemCpuLoadBetweenTicks = systemCpuLoadBetweenTicks;
	}
	public List<Long> getSystemCpuLoadTicks() {
		return systemCpuLoadTicks;
	}
	public void setSystemCpuLoadTicks(List<Long> systemCpuLoadTicks) {
		this.systemCpuLoadTicks = systemCpuLoadTicks;
	}
	public Double getSystemCpuLoad() {
		return systemCpuLoad;
	}
	public void setSystemCpuLoad(Double systemCpuLoad) {
		this.systemCpuLoad = systemCpuLoad;
	}
	public Double getSystemLoadAverage() {
		return systemLoadAverage;
	}
	public void setSystemLoadAverage(Double systemLoadAverage) {
		this.systemLoadAverage = systemLoadAverage;
	}
	public List<Double> getSystemLoadAverages() {
		return systemLoadAverages;
	}
	public void setSystemLoadAverages(List<Double> systemLoadAverages) {
		this.systemLoadAverages = systemLoadAverages;
	}
	public List<Double> getProcessorCpuLoadBetweenTicks() {
		return processorCpuLoadBetweenTicks;
	}
	public void setProcessorCpuLoadBetweenTicks(List<Double> processorCpuLoadBetweenTicks) {
		this.processorCpuLoadBetweenTicks = processorCpuLoadBetweenTicks;
	}
	public Long getSystemUptime() {
		return systemUptime;
	}
	public void setSystemUptime(Long systemUptime) {
		this.systemUptime = systemUptime;
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
	public Long[][] getProcessorCpuLoadTicks() {
		return processorCpuLoadTicks;
	}
	public void setProcessorCpuLoadTicks(Long[][] processorCpuLoadTicks) {
		this.processorCpuLoadTicks = processorCpuLoadTicks;
	}
    
    
}
