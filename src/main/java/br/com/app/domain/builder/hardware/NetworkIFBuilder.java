package br.com.app.domain.builder.hardware;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Network;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.util.DomainBuilder;

public class NetworkIFBuilder {

	private ColetaResultado coletaResultado;

	public NetworkIFBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public NetworkIF builder() {

		NetworkIF networkIF = new NetworkIF();
		networkIF.setId(coletaResultado.getId());
		List<Network> network = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), Network.class);
		networkIF.setNetworks(network);
		return networkIF;
	}
}
