package br.com.app.controller.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Sensor;
import br.com.app.service.hardware.SensorService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

	private Logger logger = LoggerFactory.getLogger(SensorController.class);
	
	@Autowired
	private SensorService sensorsService;
	
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		  ConvertJson convertJson = new ConvertJson();
		   
		  Sensor sensor  =  (Sensor) convertJson.jsonToObject(coletaResultado.getJson(), Sensor.class);
		  sensor.setId(coletaResultado.getId());
		  sensorsService.save(sensor);
	}
}
