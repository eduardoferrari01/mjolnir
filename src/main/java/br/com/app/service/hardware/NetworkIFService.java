package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.NetworkIF;
import br.com.app.repository.hardware.NetworkIFRepository;

@Service
public class NetworkIFService {

	@Autowired
	private NetworkIFRepository networkIFRepository;
	
	public void save(NetworkIF networkIFs) {
		
		networkIFRepository.save(networkIFs);
	}
}
