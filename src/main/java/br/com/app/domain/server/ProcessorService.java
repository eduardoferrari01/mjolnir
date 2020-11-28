package br.com.app.domain.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.Processor;
import br.com.app.repository.ProcessorRepository;

@Service
public class ProcessorService {

	@Autowired
	private ProcessorRepository processorRepository;
	
	public void save(Processor processor) {
		
		processorRepository.save(processor);
	}
	
	public List<Processor> findAll(){
		
		return processorRepository.findAll();
	}
	
	public Processor findById(String id) throws NotFoundException {
		
		return processorRepository.findById(id).orElseThrow(() -> new  NotFoundException()); 
	}
}
