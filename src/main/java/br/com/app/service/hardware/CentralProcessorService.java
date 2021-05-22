package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.NotFoundException;
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.repository.hardware.CentralProcessorRepository;

@Service
public class CentralProcessorService {

	@Autowired
	private CentralProcessorRepository processorRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		CentralProcessor processor = new CentralProcessorBuilder(coletaResultado).builder();
		processorRepository.save(processor);
	}
	
	public CentralProcessor findById(String id) throws NotFoundException {
		
		return processorRepository.findById(id).orElseThrow(() -> new  NotFoundException()); 
	}
}
