package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.NetworkParamsBuilder;
import br.com.app.domain.os.NetworkParams;
import br.com.app.repository.os.NetworkParamsRepository;

@Service
public class NetworkParamsService {

	@Autowired
	private NetworkParamsRepository networkParamsRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		NetworkParams networkParams = new NetworkParamsBuilder(coletaResultado).builder();
		networkParamsRepository.save(networkParams);
	}
}
