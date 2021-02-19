package br.com.app.controller.os;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;

@RestController
@RequestMapping("/api/versioninfo")
public class VersionInfoController {

	 private Logger logger = LoggerFactory.getLogger(VersionInfoController.class);
		
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping
		public void post(@RequestBody ColetaResultado coletaResultado) {
			
			 
		}
}
