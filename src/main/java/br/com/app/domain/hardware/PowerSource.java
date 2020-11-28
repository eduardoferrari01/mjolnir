package br.com.app.domain.hardware;

import java.time.LocalDate;

public class PowerSource {

    enum CapacityUnits {
      
        MWH,

      
        MAH,

        RELATIVE;
    }

	private String name;

	private String deviceName;

	private Double remainingCapacityPercent;

	private Double timeRemainingEstimated;

	private Double timeRemainingInstant;

	private Double powerUsageRate;

	private Double voltage;

	private Double amperage;

	private Boolean powerOnLine;

	private Boolean charging;

	private Boolean discharging;

	private CapacityUnits capacityUnits;

	private Integer currentCapacity;

	private Integer maxCapacity;

	private Integer designCapacity;

	private Integer cycleCount;

	private String chemistry;

	private LocalDate manufactureDate;

	private String manufacturer;

	private String serialNumber;

	private Double temperature;

	private Boolean updateAttributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Double getRemainingCapacityPercent() {
		return remainingCapacityPercent;
	}

	public void setRemainingCapacityPercent(Double remainingCapacityPercent) {
		this.remainingCapacityPercent = remainingCapacityPercent;
	}

	public Double getTimeRemainingEstimated() {
		return timeRemainingEstimated;
	}

	public void setTimeRemainingEstimated(Double timeRemainingEstimated) {
		this.timeRemainingEstimated = timeRemainingEstimated;
	}

	public Double getTimeRemainingInstant() {
		return timeRemainingInstant;
	}

	public void setTimeRemainingInstant(Double timeRemainingInstant) {
		this.timeRemainingInstant = timeRemainingInstant;
	}

	public Double getPowerUsageRate() {
		return powerUsageRate;
	}

	public void setPowerUsageRate(Double powerUsageRate) {
		this.powerUsageRate = powerUsageRate;
	}

	public Double getVoltage() {
		return voltage;
	}

	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}

	public Double getAmperage() {
		return amperage;
	}

	public void setAmperage(Double amperage) {
		this.amperage = amperage;
	}

	public Boolean getPowerOnLine() {
		return powerOnLine;
	}

	public void setPowerOnLine(Boolean powerOnLine) {
		this.powerOnLine = powerOnLine;
	}

	public Boolean getCharging() {
		return charging;
	}

	public void setCharging(Boolean charging) {
		this.charging = charging;
	}

	public Boolean getDischarging() {
		return discharging;
	}

	public void setDischarging(Boolean discharging) {
		this.discharging = discharging;
	}

	public CapacityUnits getCapacityUnits() {
		return capacityUnits;
	}

	public void setCapacityUnits(CapacityUnits capacityUnits) {
		this.capacityUnits = capacityUnits;
	}

	public Integer getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(Integer currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Integer getDesignCapacity() {
		return designCapacity;
	}

	public void setDesignCapacity(Integer designCapacity) {
		this.designCapacity = designCapacity;
	}

	public Integer getCycleCount() {
		return cycleCount;
	}

	public void setCycleCount(Integer cycleCount) {
		this.cycleCount = cycleCount;
	}

	public String getChemistry() {
		return chemistry;
	}

	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Boolean getUpdateAttributes() {
		return updateAttributes;
	}

	public void setUpdateAttributes(Boolean updateAttributes) {
		this.updateAttributes = updateAttributes;
	}

}
