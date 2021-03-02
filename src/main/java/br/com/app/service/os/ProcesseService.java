package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.ProcesseBuilder;
import br.com.app.domain.os.Processe;
import br.com.app.repository.os.ProcesseRepository;

public class ProcesseService {

	@Autowired
	private ProcesseRepository processeRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		Processe processe = new ProcesseBuilder(coletaResultado).builder();
		processeRepository.save(processe);
	}
}
