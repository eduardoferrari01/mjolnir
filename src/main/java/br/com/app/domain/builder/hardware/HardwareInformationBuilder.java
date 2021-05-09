package br.com.app.domain.builder.hardware;

import java.util.ArrayList;
import java.util.List;

import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.Display;
import br.com.app.domain.hardware.Displays;
import br.com.app.dto.HardwareInformation;

public class HardwareInformationBuilder {

	private ComputerSystem computerSystem;
	private CentralProcessor centralProcessor;
	private Displays displays;

	public HardwareInformationBuilder(ComputerSystem computerSystem, CentralProcessor centralProcessor,
			Displays displays) {

		this.computerSystem = computerSystem;
		this.centralProcessor = centralProcessor;
		this.displays = displays;
	}

	public HardwareInformation builderToDto() {

		HardwareInformation hardwareInformation = new HardwareInformation();
		setComputerSystem(hardwareInformation);
		setCentralProcessor(hardwareInformation);
		setDisplays(hardwareInformation);
		return hardwareInformation;
	}
	
	private void setComputerSystem(HardwareInformation hardwareInformation) {
		
		hardwareInformation.setManufacturer(computerSystem.getManufacturer());
		hardwareInformation.setModel(computerSystem.getModel());
		hardwareInformation.setSerialNumber(computerSystem.getSerialNumber());
		hardwareInformation.setBaseboardManufacturer(computerSystem.getBaseboard().getManufacturer());
		hardwareInformation.setBaseboardModel(computerSystem.getBaseboard().getModel());
		hardwareInformation.setBaseboardSerialNumber(computerSystem.getBaseboard().getSerialNumber());
		hardwareInformation.setBaseboardVersion(computerSystem.getBaseboard().getVersion());
		hardwareInformation.setFirmwareDescription(computerSystem.getFirmware().getDescription());
		hardwareInformation.setFirmwareManufacturer(computerSystem.getFirmware().getManufacturer());
		hardwareInformation.setFirmwareName(computerSystem.getFirmware().getName());
		hardwareInformation.setFirmwareReleaseDate(computerSystem.getFirmware().getReleaseDate());
		hardwareInformation.setFirmwareVersion(computerSystem.getFirmware().getVersion());
	}
	
	private void setCentralProcessor(HardwareInformation hardwareInformation) {
 	
		hardwareInformation.setProcessorName(centralProcessor.getProcessorIdentifier().getName());
		hardwareInformation.setProcessorPhysicalPackageCount(centralProcessor.getPhysicalPackageCount());
		hardwareInformation.setProcessorPhysicalProcessorCount(centralProcessor.getPhysicalProcessorCount());
		hardwareInformation.setProcessorLogicalProcessorCount(centralProcessor.getLogicalProcessorCount());
		hardwareInformation.setProcessorIdentifier(centralProcessor.getProcessorIdentifier().getIdentifier());
		hardwareInformation.setProcessorID(centralProcessor.getProcessorIdentifier().getProcessorID());
		hardwareInformation.setProcessorMicroarchitecture(centralProcessor.getProcessorIdentifier().getMicroarchitecture());
	}
	
	private void setDisplays(HardwareInformation hardwareInformation) {
		
		List<Display> listDisplays = displays.getDisplays();
		List<String> displays = new ArrayList<String>();
		
		for (Display disply : listDisplays) {
			
			displays.addAll(disply.getEdid());
		}
		hardwareInformation.setDisplays(displays);
	}
}
