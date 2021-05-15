package br.com.app.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.Agente;
import br.com.app.service.config.AgenteService;

@RestController
@RequestMapping("/api/config")
public class AgenteController {

	@Autowired
	private AgenteService agenteService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public Agente createAgente(@RequestBody String hostName) {

		return agenteService.createAgente(hostName);
	}
	
	@GetMapping("/{id}")
	public Agente findById(@PathVariable String id) {
		
		return agenteService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping
	public void update(@RequestBody Agente agente) {
	
		agenteService.save(agente);
	}
	
}