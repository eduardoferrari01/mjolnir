package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.builder.hardware.HardwareInformationBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.Displays;
import br.com.app.dto.HardwareInformation;

@Service
public class HardwareInformationService {

	@Autowired
	private ComputerSystemService computerSystemService;
	@Autowired
	private CentralProcessorService centralProcessorService;
	@Autowired
	private DisplaysService displaysService;

	public HardwareInformation findById(String id) {

		ComputerSystem computerSystem = computerSystemService.findById(id);
		CentralProcessor centralProcessor = centralProcessorService.findById(id);
		Displays displays = displaysService.findById(id);
		return new HardwareInformationBuilder(computerSystem, centralProcessor, displays).builderToDto();
	}
}
