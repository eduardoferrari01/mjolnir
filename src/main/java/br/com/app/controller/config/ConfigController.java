package br.com.app.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ConfigAgente;
import br.com.app.service.config.ConfigAgenteService;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

	@Autowired
	private ConfigAgenteService configAgenteService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ConfigAgente createConfig(@RequestBody String hostName) {

		return configAgenteService.createConfig(hostName);
	}
	
	@GetMapping("/{id}")
	public ConfigAgente findById(@PathVariable String id) {
		
		return configAgenteService.findById(id);
	}
	
}