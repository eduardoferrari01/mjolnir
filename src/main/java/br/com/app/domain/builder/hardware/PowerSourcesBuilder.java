package br.com.app.domain.builder.hardware;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.PowerSource;
import br.com.app.domain.hardware.PowerSources;
import br.com.app.util.DomainBuilder;

public class PowerSourcesBuilder {

	private ColetaResultado coletaResultado;

	public PowerSourcesBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public PowerSources builder() {

		PowerSources powerSources = new PowerSources();
		powerSources.setId(coletaResultado.getId());
		List<PowerSource> powerSource = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), PowerSource.class);
		powerSources.setPowerSources(powerSource);
		return powerSources;
	}
}
