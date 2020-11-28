package br.com.app.controller.hardware;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.util.ConvertJson;
 

@RestController
@RequestMapping("/api/computersystem")
public class ComputerSystemController {

  @PostMapping
  public void post(@RequestBody ColetaResultado coletaResultado) {
  
	 // System.out.println(coletaResultado.getJson());
	  ConvertJson convertJson = new ConvertJson();
	  ComputerSystem system = (ComputerSystem) convertJson.jsonToObject(coletaResultado.getJson(), ComputerSystem.class);
	 
  }

}