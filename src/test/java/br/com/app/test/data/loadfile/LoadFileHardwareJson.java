package br.com.app.test.data.loadfile;

public class LoadFileHardwareJson extends LoadFileJsonAbstract{

	public String loadComputerSystem() {
		return readFile("computerSystem.json");
	}
	
	public String loadDisks() {
		return readFile("disks.json");
	}
	
	public String loadDisplays() {
		return readFile("displays.json");
	}
	
	public String loadGraphicsCards() {
		return readFile("graphicsCards.json");
	}
	
	public String loadMemory() {
		return readFile("memory.json");
	}
	
	public String loadNetworkIF() {
		return readFile("networkIF.json");
	}
	
	public String  loadPowerSources() {
		return readFile("powerSources.json");
	}
	
	public String  loadProcessor() {
		return readFile("processor.json");
	}
	
	public String  loadSensor() {
		return readFile("sensor.json");
	}
	
	@Override
	protected String getPath() {
		return "src/test/resources/";
	}

}
