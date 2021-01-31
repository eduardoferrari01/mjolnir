package br.com.app.domain.hardware;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sensor {

	@Id
	private String id;
	
	private Double cpuTemperature;
	private List<Integer>fanSpeeds;
	private Double cpuVoltage;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
