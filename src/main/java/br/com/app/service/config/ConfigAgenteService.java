package br.com.app.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ConfigAgente;
import br.com.app.repository.config.ConfigAgenteRepository;

@Service
public class ConfigAgenteService {

	@Autowired
	private ConfigAgenteRepository configAgenteRepository;
	
	public void save(ConfigAgente configAgente) {
		
		configAgenteRepository.save(configAgente);
	}
	
	public ConfigAgente findByHostName(String hostName) {
		
		return configAgenteRepository.findByHostName(hostName);
	}
	
	public ConfigAgente findById(String id) {
		
		return configAgenteRepository.findById(id).get();
	}
}
