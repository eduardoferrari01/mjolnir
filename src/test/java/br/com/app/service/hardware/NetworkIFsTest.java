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
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.repository.hardware.NetworkIFRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class NetworkIFsTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private NetworkIFService networkIFService;
	@Mock
	private NetworkIFRepository networkIFRepository;  
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadNetworkIF()).builder();
	}
	
	@Test
	public void deveSalvarUmNetworkIFs() throws IOException {

		networkIFService.save(coletaResultado);
		verify(networkIFRepository).save(Mockito.any(NetworkIF.class));
	}
	
}
