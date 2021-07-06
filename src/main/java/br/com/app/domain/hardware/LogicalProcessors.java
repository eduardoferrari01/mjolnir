package br.com.app.domain.hardware;

public class LogicalProcessors {

	private Integer processorNumber;
	private Integer physicalProcessorNumber;
	private Integer physicalPackageNumber;
	private Integer numaNode;
	private Integer processorGroup;

	public Integer getProcessorNumber() {
		return processorNumber;
	}

	public void setProcessorNumber(Integer processorNumber) {
		this.processorNumber = processorNumber;
	}

	public Integer getPhysicalProcessorNumber() {
		return physicalProcessorNumber;
	}

	public void setPhysicalProcessorNumber(Integer physicalProcessorNumber) {
		this.physicalProcessorNumber = physicalProcessorNumber;
	}

	public Integer getPhysicalPackageNumber() {
		return physicalPackageNumber;
	}

	public void setPhysicalPackageNumber(Integer physicalPackageNumber) {
		this.physicalPackageNumber = physicalPackageNumber;
	}

	public Integer getNumaNode() {
		return numaNode;
	}

	public void setNumaNode(Integer numaNode) {
		this.numaNode = numaNode;
	}

	public Integer getProcessorGroup() {
		return processorGroup;
	}

	public void setProcessorGroup(Integer processorGroup) {
		this.processorGroup = processorGroup;
	}

}
