package br.com.app.domain;

import java.util.List;


public class Hardware {

	private ComputerSystem computerSystem;
	private Processor processor;
	private Memory memory;
	private List<PowerSource> powerSources;
	private List<DiskStore> disks;
	private List<Network> networks;
	private List<Display> displays;
	private Sensors sensors;
	private List<UsbDevice> usbDevices;

	public ComputerSystem getComputerSystem() {
		return computerSystem;
	}

	public void setComputerSystem(ComputerSystem computerSystem) {
		this.computerSystem = computerSystem;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public List<PowerSource> getPowerSources() {
		return powerSources;
	}

	public void setPowerSources(List<PowerSource> powerSources) {
		this.powerSources = powerSources;
	}
	
	 

	public List<DiskStore> getDisks() {
		return disks;
	}

	public void setDisks(List<DiskStore> disks) {
		this.disks = disks;
	}
	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

	public Sensors getSensors() {
		return sensors;
	}

	public void setSensors(Sensors sensors) {
		this.sensors = sensors;
	}

	public List<UsbDevice> getUsbDevices() {
		return usbDevices;
	}

	public void setUsbDevices(List<UsbDevice> usbDevices) {
		this.usbDevices = usbDevices;
	}
	
	
}
