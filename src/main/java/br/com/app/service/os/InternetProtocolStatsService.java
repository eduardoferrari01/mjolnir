package br.com.app.service.os;

import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.InternetProtocolStatsBuilder;
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.repository.os.InternetProtocolStatsRepository;

@Service
public class InternetProtocolStatsService {

	private InternetProtocolStatsRepository internetProtocolStatsRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		InternetProtocolStats internetProtocolStats = new InternetProtocolStatsBuilder(coletaResultado).builder();
		
		internetProtocolStatsRepository.save(internetProtocolStats);
	}
}
