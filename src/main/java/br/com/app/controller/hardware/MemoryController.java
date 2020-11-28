package br.com.app.controller.hardware;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Memory;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/memory")
public class MemoryController {

	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		//System.out.println(coletaResultado.getJson());
		ConvertJson convertJson = new ConvertJson();
		//não esta sendo enviado os atributos PhysicalMemory pq não tem no meu pc
		Memory memory = (Memory) convertJson.jsonToObject(coletaResultado.getJson(), Memory.class);
		
	}
}
