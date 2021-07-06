package br.com.app.controller.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.service.hardware.MemoryService;

@RestController
@RequestMapping("/api/memory")
public class MemoryController {

	private Logger logger = LoggerFactory.getLogger(MemoryController.class);
	
	@Autowired
	private MemoryService memoryService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		memoryService.save(coletaResultado);
	}
}
