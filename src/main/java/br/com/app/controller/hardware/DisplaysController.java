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
import br.com.app.domain.hardware.Display;
import br.com.app.domain.hardware.Displays;
import br.com.app.service.hardware.DisplaysService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/displays")
public class DisplaysController {

	private Logger logger = LoggerFactory.getLogger(DisplaysController.class);
	
	@Autowired
	private DisplaysService displaysService;
	
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		ConvertJson convertJson = new ConvertJson();
		//System.out.println(coletaResultado.getJson());
		
		List<Object> objects =   convertJson.jsonToListObject(coletaResultado.getJson(), Display.class);
		
		Displays displays = new Displays();
		displays.setId(coletaResultado.getId());
		
		for (Object object : objects) {
			
			Display display = (Display) object;
			displays.add(display);
		}
		
		displaysService.save(displays);
	}
}
