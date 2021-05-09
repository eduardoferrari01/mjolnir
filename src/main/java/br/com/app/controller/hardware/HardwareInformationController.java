package br.com.app.controller.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.dto.HardwareInformation;
import br.com.app.service.hardware.HardwareInformationService;

@RestController
@RequestMapping("/api/hardwareinformation")
public class HardwareInformationController {

	private Logger logger = LoggerFactory.getLogger(ComputerSystemController.class);
	@Autowired
	private HardwareInformationService hardwareInformationService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public HardwareInformation findById(@PathVariable String id) {
		
		logger.info("Find hardware informationid by id: " + id);
		return hardwareInformationService.findById(id);
	}
}
