package br.com.app.controller.hardware;

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
import br.com.app.service.hardware.DisksService;

@RestController
@RequestMapping("/api/diskstores")
public class DiskStoresController {

	private Logger logger = LoggerFactory.getLogger(DiskStoresController.class);
	@Autowired
	private DisksService disksService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		disksService.save(coletaResultado);
	}
}
