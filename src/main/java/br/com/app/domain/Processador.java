package br.com.app.domain;

public class Processador {

	private String name;
	private String physicalProcessorCount;
	private String logicalProcessorCount;
	private String processorID;
	private String Identifier;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhysicalProcessorCount() {
		return physicalProcessorCount;
	}
	public void setPhysicalProcessorCount(String physicalProcessorCount) {
		this.physicalProcessorCount = physicalProcessorCount;
	}
	public String getLogicalProcessorCount() {
		return logicalProcessorCount;
	}
	public void setLogicalProcessorCount(String logicalProcessorCount) {
		this.logicalProcessorCount = logicalProcessorCount;
	}
	public String getProcessorID() {
		return processorID;
	}
	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}
	public String getIdentifier() {
		return Identifier;
	}
	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}
	
	
	
}
