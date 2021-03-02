package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.OperatingSystemBuilder;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.repository.os.OperatingSystemRepository;

@Service
public class OperatingSystemService {

	@Autowired
	private OperatingSystemRepository operatingSystemRepository;
	 
	public void save(ColetaResultado coletaResultado) {
		
		OperatingSystem operatingSystem = new OperatingSystemBuilder(coletaResultado).builder();
		operatingSystemRepository.save(operatingSystem);
	}
}
