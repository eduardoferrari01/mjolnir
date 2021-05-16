package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.builder.os.OperatingSystemInformationBuilder;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.dto.os.OperatingSystemInformation;

@Service
public class OperatingSystemInformationService {

	@Autowired
	private OSVersionInfoService osVersionInfoService;
	@Autowired
	private OperatingSystemService operatingSystemService;

	public OperatingSystemInformation findById(String id) {

		OSVersionInfo osVersionInfo = osVersionInfoService.findById(id);
		OperatingSystem operatingSystem = operatingSystemService.findById(id);

		return new OperatingSystemInformationBuilder(osVersionInfo, operatingSystem).builderToDto();
	}
}
