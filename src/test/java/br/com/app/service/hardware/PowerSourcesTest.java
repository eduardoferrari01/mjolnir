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
import br.com.app.domain.hardware.PowerSources;
import br.com.app.repository.hardware.PowerSourcesRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class PowerSourcesTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private PowerSourcesService powerSourcesService;
	@Mock
	private PowerSourcesRepository powerSourcesRepository;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadPowerSources()).builder();
	}
	
	@Test
	public void deveSalvarUmPowerSources() throws IOException {

		powerSourcesService.save(coletaResultado);
		verify(powerSourcesRepository).save(Mockito.any(PowerSources.class));
	}
	
}
