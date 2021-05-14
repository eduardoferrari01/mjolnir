package br.com.app.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.Agente;
import br.com.app.repository.config.AgenteRepository;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository agenteRepository;
	
	public Agente createAgente(String hostName) {
		
		Agente agente = agenteRepository.findByHostName(hostName);

		if (agente == null) {

			agente = new Agente.Builder(hostName).build();
			agenteRepository.save(agente);
		}
		
		return agente;
	}
	
	public Agente findByHostName(String hostName) {
		
		return agenteRepository.findByHostName(hostName);
	}
	
	public Agente findById(String id) {
		
		return agenteRepository.findById(id).get();
	}
}
