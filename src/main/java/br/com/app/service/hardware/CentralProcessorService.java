package br.com.app.service.hardware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.NotFoundException;
import br.com.app.domain.builder.hardware.ProcessorBuilder;
import br.com.app.domain.hardware.Processor;
import br.com.app.repository.hardware.ProcessorRepository;

@Service
public class ProcessorService {

	@Autowired
	private ProcessorRepository processorRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		Processor processor = new ProcessorBuilder(coletaResultado).builder();
		processorRepository.save(processor);
	}
	
	public List<Processor> findAll(){
		
		return processorRepository.findAll();
	}
	
	public Processor findById(String id) throws NotFoundException {
		
		return processorRepository.findById(id).orElseThrow(() -> new  NotFoundException()); 
	}
}
