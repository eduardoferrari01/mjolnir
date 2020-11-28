package br.com.app.controller.hardware;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Sensors;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/sensors")
public class SensorsController {

	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		  //System.out.println(coletaResultado.getJson());
		 
		  ConvertJson convertJson = new ConvertJson();
		   
		  Sensors sensor  =  (Sensors) convertJson.jsonToObject(coletaResultado.getJson(), Sensors.class);
		
	}
}
