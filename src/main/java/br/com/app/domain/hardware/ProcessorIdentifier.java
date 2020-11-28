package br.com.app.domain.hardware;

public class ProcessorIdentifier {

	private String processorID;
	private Boolean cpu64bit;
	private String model;
	private String vendor;
	private String stepping;
	private Long vendorFreq;
	private String microarchitecture;
	private String identifier;
	private String family;
	private String name;
	
	public String getProcessorID() {
		return processorID;
	}
	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}
	public Boolean getCpu64bit() {
		return cpu64bit;
	}
	public void setCpu64bit(Boolean cpu64bit) {
		this.cpu64bit = cpu64bit;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getStepping() {
		return stepping;
	}
	public void setStepping(String stepping) {
		this.stepping = stepping;
	}
	public Long getVendorFreq() {
		return vendorFreq;
	}
	public void setVendorFreq(Long vendorFreq) {
		this.vendorFreq = vendorFreq;
	}
	public String getMicroarchitecture() {
		return microarchitecture;
	}
	public void setMicroarchitecture(String microarchitecture) {
		this.microarchitecture = microarchitecture;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
