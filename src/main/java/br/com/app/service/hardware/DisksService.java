package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.Disks;
import br.com.app.repository.hardware.DisksRepository;

@Service
public class DisksService {

	@Autowired
	private DisksRepository disksRepository;
	
	public void save(Disks disks) {
		
		disksRepository.save(disks);
	}
}
