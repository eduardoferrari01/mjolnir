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
import br.com.app.service.os.OperatingSystemService;

@RestController
@RequestMapping("/api/operatingsystem")
public class OperatingSystemController {

	private Logger logger = LoggerFactory.getLogger(OperatingSystemController.class);

	@Autowired
	private OperatingSystemService operatingSystemService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		operatingSystemService.save(coletaResultado);
	}
}
