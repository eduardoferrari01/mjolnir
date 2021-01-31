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
import br.com.app.domain.hardware.Network;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.service.hardware.NetworkIFService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/networkifs")
public class NetworkIFsController {

	private Logger logger = LoggerFactory.getLogger(NetworkIFsController.class);
	
	@Autowired
	private NetworkIFService networkIFService;
	
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		ConvertJson convertJson = new ConvertJson();

		List<Object> objects = convertJson.jsonToListObject(coletaResultado.getJson(), Network.class);

		NetworkIF networkIF = new NetworkIF();
		
		networkIF.setId(coletaResultado.getId());
		
		for (Object obj : objects) {

			Network network = (Network) obj;
			networkIF.add(network);
		}
		
		networkIFService.save(networkIF);

	}
}
