package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.Displays;
import br.com.app.repository.hardware.DisplaysRepository;

@Service
public class DisplaysService {

	@Autowired
	private DisplaysRepository displaysRepository;
	
	public void save(Displays displays) {
		
		displaysRepository.save(displays);
	}
}
