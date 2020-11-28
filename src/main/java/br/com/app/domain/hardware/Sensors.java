package br.com.app.domain.hardware;

import java.util.List;

public class Sensors {

	private Double cpuTemperature;
	private List<Integer>fanSpeeds;
	private Double cpuVoltage;
	
	public Double getCpuTemperature() {
		return cpuTemperature;
	}
	public void setCpuTemperature(Double cpuTemperature) {
		this.cpuTemperature = cpuTemperature;
	}
	public List<Integer> getFanSpeeds() {
		return fanSpeeds;
	}
	public void setFanSpeeds(List<Integer> fanSpeeds) {
		this.fanSpeeds = fanSpeeds;
	}
	public Double getCpuVoltage() {
		return cpuVoltage;
	}
	public void setCpuVoltage(Double cpuVoltage) {
		this.cpuVoltage = cpuVoltage;
	}
	
	
}
