package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.ServiceOSBuilder;
import br.com.app.domain.os.ServiceOS;
import br.com.app.repository.os.ServiceOSRepository;

@Service
public class ServiceOSService {
	
	@Autowired
	private ServiceOSRepository serviceOSRepository;
	 
	public void save(ColetaResultado coletaResultado) {
		
		ServiceOS serviceOS = new ServiceOSBuilder(coletaResultado).builder();
		serviceOSRepository.save(serviceOS);
	}
}
