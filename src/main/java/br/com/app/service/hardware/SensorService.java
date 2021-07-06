package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.SensorBuilder;
import br.com.app.domain.hardware.Sensor;
import br.com.app.repository.hardware.SensorRepository;

@Service
public class SensorService {

	@Autowired
	private SensorRepository sensorsRepository;

	public void save(ColetaResultado coletaResultado) {

		Sensor sensor = new SensorBuilder(coletaResultado).builder();
		sensorsRepository.save(sensor);
	}
}