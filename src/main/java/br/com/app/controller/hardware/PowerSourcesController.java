package br.com.app.controller.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.service.hardware.PowerSourcesService;

@RestController
@RequestMapping("/api/powersources")
public class PowerSourcesController {

	private Logger logger = LoggerFactory.getLogger(PowerSourcesController.class);
	
	@Autowired
	private PowerSourcesService powerSourcesService;

	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		powerSourcesService.save(coletaResultado);
	}
}
