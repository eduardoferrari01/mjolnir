package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.SensorBuilder;
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
	
	@Test
	public void deveConstruirSensor(){
		
		Sensor sensor = new SensorBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(sensor);
		Assertions.assertEquals(coletaResultado.getId(), sensor.getId());
		Assertions.assertEquals(47.0, sensor.getCpuTemperature());
		Assertions.assertEquals(0.0, sensor.getCpuVoltage());
		Assertions.assertFalse(sensor.getFanSpeeds().isEmpty());
		Assertions.assertEquals(Arrays.asList(50, 10), sensor.getFanSpeeds());
	}
}