package br.com.app.domain;

import java.util.List;


public class HardwareAbstractionLayer {

	private ComputerSystem computerSystem;
	private CentralProcessor processor;
	private GlobalMemory memory;
	private List<PowerSource> powerSources;
	private List<HWDiskStore> diskStores;
	private List<NetworkIF> networkIFs;
	private List<Display> displays;
	private Sensors sensors;
	private List<UsbDevice> usbDevices;

	public ComputerSystem getComputerSystem() {
		return computerSystem;
	}

	public void setComputerSystem(ComputerSystem computerSystem) {
		this.computerSystem = computerSystem;
	}

	public CentralProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(CentralProcessor processor) {
		this.processor = processor;
	}

	public GlobalMemory getMemory() {
		return memory;
	}

	public void setMemory(GlobalMemory memory) {
		this.memory = memory;
	}

	public List<PowerSource> getPowerSources() {
		return powerSources;
	}

	public void setPowerSources(List<PowerSource> powerSources) {
		this.powerSources = powerSources;
	}

	public List<HWDiskStore> getDiskStores() {
		return diskStores;
	}

	public void setDiskStores(List<HWDiskStore> diskStores) {
		this.diskStores = diskStores;
	}

	public List<NetworkIF> getNetworkIFs() {
		return networkIFs;
	}

	public void setNetworkIFs(List<NetworkIF> networkIFs) {
		this.networkIFs = networkIFs;
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
