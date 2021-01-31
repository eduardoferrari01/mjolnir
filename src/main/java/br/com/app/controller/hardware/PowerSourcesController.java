package br.com.app.controller.hardware;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.PowerSource;
import br.com.app.domain.hardware.PowerSources;
import br.com.app.service.hardware.PowerSourcesService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/powersources")
public class PowerSourcesController {

	private Logger logger = LoggerFactory.getLogger(PowerSourcesController.class);
	
	@Autowired
	private PowerSourcesService powerSourcesService;

	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		ConvertJson convertJson = new ConvertJson();
		List<Object> objects = convertJson.jsonToListObject(coletaResultado.getJson(), PowerSource.class);

		PowerSources powerSources = new PowerSources();
		powerSources.setId(coletaResultado.getId());

		for (Object object : objects) {

			PowerSource powerSource = (PowerSource) object;

			powerSources.add(powerSource);
		}

		powerSourcesService.save(powerSources);
	}
}
