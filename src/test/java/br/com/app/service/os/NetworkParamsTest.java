package br.com.app.service.os;

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
import br.com.app.domain.os.NetworkParams;
import br.com.app.repository.os.NetworkParamsRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class NetworkParamsTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private NetworkParamsService networkParamsService;
	@Mock
	private NetworkParamsRepository networkParamsRepository;
	
	@BeforeAll
	public static void setup() throws IOException {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadFileOSJson.loadNetworkParams()).builder();
	}

	@Test
	public void deveSalvarUmNetworkParams() {

		networkParamsService.save(coletaResultado);
		verify(networkParamsRepository).save(Mockito.any(NetworkParams.class));
	}
}
