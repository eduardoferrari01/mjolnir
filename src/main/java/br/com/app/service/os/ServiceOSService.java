package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.ServiceBuilder;
import br.com.app.domain.os.Service;
import br.com.app.repository.os.ServiceOSRepository;

public class ServiceOSService {
	
	@Autowired
	private ServiceOSRepository serviceOSRepository;
	 
	public void save(ColetaResultado coletaResultado) {
		
		Service serviceOS = new ServiceBuilder(coletaResultado).builder();
		serviceOSRepository.save(serviceOS);
	}
}
