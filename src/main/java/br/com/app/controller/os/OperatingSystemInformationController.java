package br.com.app.controller.os;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.dto.os.OperatingSystemInformation;
import br.com.app.service.os.OperatingSystemInformationService;

@RestController
@RequestMapping("/api/operatingsysteminformation")
public class OperatingSystemInformationController {

	private Logger logger = LoggerFactory.getLogger(OperatingSystemInformationController.class);
	@Autowired
	private OperatingSystemInformationService operatingSystemInformationService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public OperatingSystemInformation findById(@PathVariable String id) {
		
		logger.info("Find operating system information by id: " + id);
		return operatingSystemInformationService.findById(id);
	}
}

 
