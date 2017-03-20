package br.com.app.domain;

public class PowerSource {

	private String name;

    private Double remainingCapacity;

    private Double timeRemaining;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRemainingCapacity() {
		return remainingCapacity;
	}

	public void setRemainingCapacity(Double remainingCapacity) {
		this.remainingCapacity = remainingCapacity;
	}

	public Double getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(Double timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
    
    
    
}
