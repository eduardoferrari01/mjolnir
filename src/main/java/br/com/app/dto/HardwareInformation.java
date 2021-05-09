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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseboardManufacturer == null) ? 0 : baseboardManufacturer.hashCode());
		result = prime * result + ((baseboardModel == null) ? 0 : baseboardModel.hashCode());
		result = prime * result + ((baseboardSerialNumber == null) ? 0 : baseboardSerialNumber.hashCode());
		result = prime * result + ((baseboardVersion == null) ? 0 : baseboardVersion.hashCode());
		result = prime * result + ((displays == null) ? 0 : displays.hashCode());
		result = prime * result + ((firmwareDescription == null) ? 0 : firmwareDescription.hashCode());
		result = prime * result + ((firmwareManufacturer == null) ? 0 : firmwareManufacturer.hashCode());
		result = prime * result + ((firmwareName == null) ? 0 : firmwareName.hashCode());
		result = prime * result + ((firmwareReleaseDate == null) ? 0 : firmwareReleaseDate.hashCode());
		result = prime * result + ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((processorID == null) ? 0 : processorID.hashCode());
		result = prime * result + ((processorIdentifier == null) ? 0 : processorIdentifier.hashCode());
		result = prime * result
				+ ((processorLogicalProcessorCount == null) ? 0 : processorLogicalProcessorCount.hashCode());
		result = prime * result + ((processorMicroarchitecture == null) ? 0 : processorMicroarchitecture.hashCode());
		result = prime * result + ((processorName == null) ? 0 : processorName.hashCode());
		result = prime * result
				+ ((processorPhysicalPackageCount == null) ? 0 : processorPhysicalPackageCount.hashCode());
		result = prime * result
				+ ((processorPhysicalProcessorCount == null) ? 0 : processorPhysicalProcessorCount.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HardwareInformation other = (HardwareInformation) obj;
		if (baseboardManufacturer == null) {
			if (other.baseboardManufacturer != null)
				return false;
		} else if (!baseboardManufacturer.equals(other.baseboardManufacturer))
			return false;
		if (baseboardModel == null) {
			if (other.baseboardModel != null)
				return false;
		} else if (!baseboardModel.equals(other.baseboardModel))
			return false;
		if (baseboardSerialNumber == null) {
			if (other.baseboardSerialNumber != null)
				return false;
		} else if (!baseboardSerialNumber.equals(other.baseboardSerialNumber))
			return false;
		if (baseboardVersion == null) {
			if (other.baseboardVersion != null)
				return false;
		} else if (!baseboardVersion.equals(other.baseboardVersion))
			return false;
		if (displays == null) {
			if (other.displays != null)
				return false;
		} else if (!displays.equals(other.displays))
			return false;
		if (firmwareDescription == null) {
			if (other.firmwareDescription != null)
				return false;
		} else if (!firmwareDescription.equals(other.firmwareDescription))
			return false;
		if (firmwareManufacturer == null) {
			if (other.firmwareManufacturer != null)
				return false;
		} else if (!firmwareManufacturer.equals(other.firmwareManufacturer))
			return false;
		if (firmwareName == null) {
			if (other.firmwareName != null)
				return false;
		} else if (!firmwareName.equals(other.firmwareName))
			return false;
		if (firmwareReleaseDate == null) {
			if (other.firmwareReleaseDate != null)
				return false;
		} else if (!firmwareReleaseDate.equals(other.firmwareReleaseDate))
			return false;
		if (firmwareVersion == null) {
			if (other.firmwareVersion != null)
				return false;
		} else if (!firmwareVersion.equals(other.firmwareVersion))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (processorID == null) {
			if (other.processorID != null)
				return false;
		} else if (!processorID.equals(other.processorID))
			return false;
		if (processorIdentifier == null) {
			if (other.processorIdentifier != null)
				return false;
		} else if (!processorIdentifier.equals(other.processorIdentifier))
			return false;
		if (processorLogicalProcessorCount == null) {
			if (other.processorLogicalProcessorCount != null)
				return false;
		} else if (!processorLogicalProcessorCount.equals(other.processorLogicalProcessorCount))
			return false;
		if (processorMicroarchitecture == null) {
			if (other.processorMicroarchitecture != null)
				return false;
		} else if (!processorMicroarchitecture.equals(other.processorMicroarchitecture))
			return false;
		if (processorName == null) {
			if (other.processorName != null)
				return false;
		} else if (!processorName.equals(other.processorName))
			return false;
		if (processorPhysicalPackageCount == null) {
			if (other.processorPhysicalPackageCount != null)
				return false;
		} else if (!processorPhysicalPackageCount.equals(other.processorPhysicalPackageCount))
			return false;
		if (processorPhysicalProcessorCount == null) {
			if (other.processorPhysicalProcessorCount != null)
				return false;
		} else if (!processorPhysicalProcessorCount.equals(other.processorPhysicalProcessorCount))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}
	
	
}
