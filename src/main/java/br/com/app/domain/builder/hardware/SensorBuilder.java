package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Sensor;
import br.com.app.util.EntityBuilder;

public class SensorBuilder {

	private ColetaResultado coletaResultado;

	public SensorBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public Sensor builder() {

		Sensor sensor = new EntityBuilder().builder(coletaResultado.getJson(), Sensor.class);
		sensor.setId(coletaResultado.getId());
		return sensor;
	}
}
