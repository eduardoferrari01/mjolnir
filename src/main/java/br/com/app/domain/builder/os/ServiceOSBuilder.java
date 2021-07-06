package br.com.app.domain.builder.os;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSService;
import br.com.app.domain.os.ServiceOS;
import br.com.app.util.DomainBuilder;

public class ServiceOSBuilder {

	private ColetaResultado coletaResultado;

	public ServiceOSBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public ServiceOS builder() {

		ServiceOS service = new ServiceOS();
		service.setId(coletaResultado.getId());
		List<OSService> osService = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), OSService.class);
		service.setOsService(osService);
		return service;
	}
}
