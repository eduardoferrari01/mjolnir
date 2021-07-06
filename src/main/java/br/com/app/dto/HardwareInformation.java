package br.com.app.dto;

import java.util.List;

public class HardwareInformation {

	private String manufacturer;
	private String model;
	private String serialNumber;
	
	private String firmwareManufacturer;
	private String firmwareName;
	private String firmwareDescription;
	private String firmwareVersion;
	private String firmwareReleaseDate;
	
	private String baseboardManufacturer;
	private String baseboardModel;
	private String baseboardVersion;
	private String baseboardSerialNumber;
	
	private String processorName;
	private String processorIdentifier;
	private String processorID;
	private String processorMicroarchitecture;
	private Integer processorPhysicalPackageCount;
	private Integer processorPhysicalProcessorCount ;
	private Integer processorLogicalProcessorCount;
	
	private List<String> displays;
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getFirmwareManufacturer() {
		return firmwareManufacturer;
	}
	public void setFirmwareManufacturer(String firmwareManufacturer) {
		this.firmwareManufacturer = firmwareManufacturer;
	}
	public String getFirmwareName() {
		return firmwareName;
	}
	public void setFirmwareName(String firmwareName) {
		this.firmwareName = firmwareName;
	}
	public String getFirmwareDescription() {
		return firmwareDescription;
	}
	public void setFirmwareDescription(String firmwareDescription) {
		this.firmwareDescription = firmwareDescription;
	}
	public String getFirmwareVersion() {
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	public String getFirmwareReleaseDate() {
		return firmwareReleaseDate;
	}
	public void setFirmwareReleaseDate(String firmwareReleaseDate) {
		this.firmwareReleaseDate = firmwareReleaseDate;
	}
	public String getBaseboardManufacturer() {
		return baseboardManufacturer;
	}
	public void setBaseboardManufacturer(String baseboardManufacturer) {
		this.baseboardManufacturer = baseboardManufacturer;
	}
	public String getBaseboardModel() {
		return baseboardModel;
	}
	public void setBaseboardModel(String baseboardModel) {
		this.baseboardModel = baseboardModel;
	}
	public String getBaseboardVersion() {
		return baseboardVersion;
	}
	public void setBaseboardVersion(String baseboardVersion) {
		this.baseboardVersion = baseboardVersion;
	}
	public String getBaseboardSerialNumber() {
		return baseboardSerialNumber;
	}
	public void setBaseboardSerialNumber(String baseboardSerialNumber) {
		this.baseboardSerialNumber = baseboardSerialNumber;
	}
	
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	public String getProcessorIdentifier() {
		return processorIdentifier;
	}
	public void setProcessorIdentifier(String processorIdentifier) {
		this.processorIdentifier = processorIdentifier;
	}
	public String getProcessorID() {
		return processorID;
	}
	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}
	public String getProcessorMicroarchitecture() {
		return processorMicroarchitecture;
	}
	public void setProcessorMicroarchitecture(String processorMicroarchitecture) {
		this.processorMicroarchitecture = processorMicroarchitecture;
	}
 
	public Integer getProcessorPhysicalPackageCount() {
		return processorPhysicalPackageCount;
	}
	public void setProcessorPhysicalPackageCount(Integer processorPhysicalPackageCount) {
		this.processorPhysicalPackageCount = processorPhysicalPackageCount;
	}
	public Integer getProcessorPhysicalProcessorCount() {
		return processorPhysicalProcessorCount;
	}
	public void setProcessorPhysicalProcessorCount(Integer processorPhysicalProcessorCount) {
		this.processorPhysicalProcessorCount = processorPhysicalProcessorCount;
	}
	public Integer getProcessorLogicalProcessorCount() {
		return processorLogicalProcessorCount;
	}
	public void setProcessorLogicalProcessorCount(Integer processorLogicalProcessorCount) {
		this.processorLogicalProcessorCount = processorLogicalProcessorCount;
	}
	public List<String> getDisplays() {
		return displays;
	}
	public void setDisplays(List<String> displays) {
		this.displays = displays;
	}
}
