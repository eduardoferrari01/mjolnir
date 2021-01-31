package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.PowerSources;
import br.com.app.repository.hardware.PowerSourcesRepository;

@Service
public class PowerSourcesService {

	@Autowired
	private PowerSourcesRepository powerSourcesRepository;
	
	public void save(PowerSources powerSources) {
		
		powerSourcesRepository.save(powerSources);
	}
}
