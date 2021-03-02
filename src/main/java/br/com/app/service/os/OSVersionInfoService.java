package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.OSVersionInfoBuilder;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.repository.os.OSVersionInfoRepository;

public class OSVersionInfoService {

	@Autowired
	private OSVersionInfoRepository osVersionInfoRepository;
	
	public void save(ColetaResultado coletaResultado) {
		
		OSVersionInfo osVersionInfo = new OSVersionInfoBuilder(coletaResultado).builder();
		osVersionInfoRepository.save(osVersionInfo);
	}
}
