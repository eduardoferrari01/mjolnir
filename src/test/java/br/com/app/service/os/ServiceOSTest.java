package br.com.app.service.os;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.ServiceOS;
import br.com.app.repository.os.ServiceOSRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class ServiceOSTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private ServiceOSService serviceOSService;
	@Mock
	private ServiceOSRepository serviceOSRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadFileOSJson.loadOSService())
				.builder();
	}
	
	@Test
	public void deveSalvarUmServiceOS() {

		serviceOSService.save(coletaResultado);
		verify(serviceOSRepository).save(Mockito.any(ServiceOS.class));
	}
}
