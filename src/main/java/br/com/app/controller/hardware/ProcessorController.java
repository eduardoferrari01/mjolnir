package br.com.app.controller.hardware;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.NotFoundException;
import br.com.app.domain.hardware.Processor;
import br.com.app.service.hardware.ProcessorService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/processor")
public class ProcessorController {

	private Logger logger = LoggerFactory.getLogger(ProcessorController.class);
	
	@Autowired
	private ProcessorService processorService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		ConvertJson convertJson = new ConvertJson();
		Processor processor = (Processor) convertJson.jsonToObject(coletaResultado.getJson(), Processor.class);
		processor.setId(coletaResultado.getId());
		processorService.save(processor);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Processor> findAll(){
		
		return processorService.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Processor findById(@PathVariable String id){
		
		try {
			logger.info("Searching processor for id ="+id);
			return processorService.findById(id);
		
		}catch (NotFoundException e) {
			  
			logger.warn("Processor with id="+id+" is not found ");
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Processor is not found", e);
		}
	}
	
}
