package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.MemoryBuilder;
import br.com.app.domain.hardware.Memory;
import br.com.app.repository.hardware.MemoryRepository;

@Service
public class MemoryService {

	@Autowired
	private MemoryRepository memoryRepository;

	public void save(ColetaResultado coletaResultado) {

		Memory memory = new MemoryBuilder(coletaResultado).builder();
		memoryRepository.save(memory);
	}
}