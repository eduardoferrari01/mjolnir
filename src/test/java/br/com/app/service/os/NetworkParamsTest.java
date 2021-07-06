package br.com.app.service.os;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.NetworkParamsBuilder;
import br.com.app.domain.os.NetworkParams;
import br.com.app.repository.os.NetworkParamsRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadNetworkParams()).builder();
	}

	@Test
	public void deveSalvarUmNetworkParams() {

		networkParamsService.save(coletaResultado);
		verify(networkParamsRepository).save(Mockito.any(NetworkParams.class));
	}
	
	@Test
	public void deveConstruirNetworkParams() {

		NetworkParams networkParams = new NetworkParamsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(networkParams);
		Assertions.assertEquals(coletaResultado.getId(), networkParams.getId());
		Assertions.assertEquals("pc-teste", networkParams.getDomainName());
		Assertions.assertEquals("pc-teste", networkParams.getHostName());
		Assertions.assertEquals("", networkParams.getIpv4DefaultGateway());
		Assertions.assertEquals("", networkParams.getIpv6DefaultGateway());
		Assertions.assertFalse(networkParams.getDnsServers().isEmpty());
		
		List<String> dnsServers = new ArrayList<>();
		dnsServers.add("127.0.0.1");
		Assertions.assertEquals(dnsServers, networkParams.getDnsServers());
	}
	
}
