package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.ComputerSystemBuilder;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.repository.hardware.ComputerSystemRepository;

@Service
public class ComputerSystemService {

	@Autowired
	private ComputerSystemRepository computerSystemRepository;

	public void save(ColetaResultado coletaResultado) {

		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultado).builder();

		computerSystemRepository.save(computerSystem);

	}
}
