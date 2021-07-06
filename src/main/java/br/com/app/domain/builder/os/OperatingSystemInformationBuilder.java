package br.com.app.domain.builder.os;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.dto.os.OperatingSystemInformation;
 

public class OperatingSystemInformationBuilder {

	private OSVersionInfo osVersionInfo;
	private OperatingSystem operatingSystem;
	 

	public OperatingSystemInformationBuilder(OSVersionInfo osVersionInfo, OperatingSystem operatingSystem) {

		this.osVersionInfo = osVersionInfo;
		this.operatingSystem = operatingSystem;
		 
	}

	public OperatingSystemInformation builderToDto() {

		OperatingSystemInformation operatingSystemInformation = new OperatingSystemInformation();
	
		operatingSystemInformation.setFamily(operatingSystem.getFamily());
		operatingSystemInformation.setManufacturer(operatingSystem.getManufacturer());
		operatingSystemInformation.setBitness(operatingSystem.getBitness());
		operatingSystemInformation.setDayUptTime(operatingSystem.getDayUptTime());
		operatingSystemInformation.setHourUpTime(operatingSystem.getHourUpTime());
		operatingSystemInformation.setBootTime(operatingSystem.getBootTime());
		operatingSystemInformation.setVersionInfo(osVersionInfo.getVersionInfo());
		
		return operatingSystemInformation;
	}
}