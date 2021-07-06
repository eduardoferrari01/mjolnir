package br.com.app.domain.builder.hardware;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Display;
import br.com.app.domain.hardware.Displays;
import br.com.app.util.DomainBuilder;

public class DisplaysBuilder {

	private ColetaResultado coletaResultado;

	public DisplaysBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public Displays builder() {

		Displays displays = new Displays();
		displays.setId(coletaResultado.getId());
		List<Display> display = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), Display.class);
		displays.setDisplays(display);
		return displays;
	}
}
