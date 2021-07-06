package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.NotFoundException;
import br.com.app.domain.builder.hardware.DisplaysBuilder;
import br.com.app.domain.hardware.Displays;
import br.com.app.repository.hardware.DisplaysRepository;

@Service
public class DisplaysService {

	@Autowired
	private DisplaysRepository displaysRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		Displays displays = new DisplaysBuilder(coletaResultado).builder();
		displaysRepository.save(displays);
	}
	
	public Displays findById(String id) throws NotFoundException {
		
		return displaysRepository.findById(id).orElseThrow(() -> new  NotFoundException()); 
	}
}
