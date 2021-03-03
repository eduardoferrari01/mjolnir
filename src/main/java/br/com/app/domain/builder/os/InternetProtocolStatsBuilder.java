package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.util.DomainBuilder;

public class InternetProtocolStatsBuilder {

	private ColetaResultado coletaResultado;

	public InternetProtocolStatsBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public InternetProtocolStats builder() {

		InternetProtocolStats internetProtocolStats = new DomainBuilder().builder(coletaResultado.getJson(), InternetProtocolStats.class);
		internetProtocolStats.setId(coletaResultado.getId());
		return internetProtocolStats;
	}
}
