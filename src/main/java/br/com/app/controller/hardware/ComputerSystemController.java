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
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.service.hardware.ComputerSystemService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/computersystem")
public class ComputerSystemController {

	private Logger logger = LoggerFactory.getLogger(ComputerSystemController.class);
	
	@Autowired
	private ComputerSystemService computerSystemService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		System.out.println(coletaResultado.getJson());
		
		ConvertJson convertJson = new ConvertJson();
		ComputerSystem computerSystem = (ComputerSystem) convertJson.jsonToObject(coletaResultado.getJson(),
				ComputerSystem.class);
		computerSystem.setId(coletaResultado.getId());
		computerSystemService.save(computerSystem);
	}
	
}