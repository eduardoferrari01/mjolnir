package br.com.app.domain.builder.os;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSProcess;
import br.com.app.domain.os.Processe;
import br.com.app.util.EntityBuilder;

public class ProcesseBuilder {

	private ColetaResultado coletaResultado;

	public ProcesseBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public Processe builder() {

		Processe processe = new Processe();
		processe.setId(coletaResultado.getId());
		List<OSProcess> osProcess = new EntityBuilder().collectionBuilder(coletaResultado.getJson(), OSProcess.class);
		processe.setOsProcess(osProcess);
		return processe;
	}
}
