package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.SessionsBuilder;
import br.com.app.domain.os.Sessions;
import br.com.app.repository.os.SessionsRepository;

public class SessionsService {

	@Autowired
	private SessionsRepository sessionsRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		Sessions sessions = new SessionsBuilder(coletaResultado).builder();
		sessionsRepository.save(sessions);
	}
}
