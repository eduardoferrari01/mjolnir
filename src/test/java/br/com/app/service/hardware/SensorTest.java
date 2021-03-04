package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Sensor;
import br.com.app.repository.hardware.SensorRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class SensorTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private SensorService sensorService;
	@Mock
	private SensorRepository sensorRepository; 
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadSensor()).builder();
	}
	
	@Test
	public void deveSalvarUmPowerSources() throws IOException {

		sensorService.save(coletaResultado);
		verify(sensorRepository).save(Mockito.any(Sensor.class));
	}
}
