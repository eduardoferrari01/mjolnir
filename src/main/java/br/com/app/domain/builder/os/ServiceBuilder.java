package br.com.app.domain.builder.os;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSService;
import br.com.app.domain.os.Service;
import br.com.app.util.EntityBuilder;

public class ServiceBuilder {

	private ColetaResultado coletaResultado;

	public ServiceBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public Service builder() {

		Service service = new Service();
		service.setId(coletaResultado.getId());
		List<OSService> osService = new EntityBuilder().collectionBuilder(coletaResultado.getJson(), OSService.class);
		service.setOsService(osService);
		return service;
	}
}
