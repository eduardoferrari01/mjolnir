package br.com.app.controller.os;

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
import br.com.app.service.os.NetworkParamsService;

@RestController
@RequestMapping("/api/networkparams")
public class NetworkParamsController {

	private Logger logger = LoggerFactory.getLogger(NetworkParamsController.class);

	@Autowired
	private NetworkParamsService networkParamsService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		networkParamsService.save(coletaResultado);
	}
}
