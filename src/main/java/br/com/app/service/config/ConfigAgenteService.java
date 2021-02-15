package br.com.app.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ConfigAgente;
import br.com.app.repository.config.ConfigAgenteRepository;

@Service
public class ConfigAgenteService {

	@Autowired
	private ConfigAgenteRepository configAgenteRepository;
	
	public ConfigAgente createConfig(String hostName) {
		
		ConfigAgente configAgente = configAgenteRepository.findByHostName(hostName);

		if (configAgente == null) {

			configAgente = new ConfigAgente.Builder(hostName).build();
			configAgenteRepository.save(configAgente);
		}
		
		return configAgente;
	}
	
	public ConfigAgente findByHostName(String hostName) {
		
		return configAgenteRepository.findByHostName(hostName);
	}
	
	public ConfigAgente findById(String id) {
		
		return configAgenteRepository.findById(id).get();
	}
}
