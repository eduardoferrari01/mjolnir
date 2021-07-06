
package br.com.app.service.os;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.ServiceOSBuilder;
import br.com.app.domain.os.OSService;
import br.com.app.domain.os.OSService.State;
import br.com.app.domain.os.ServiceOS;
import br.com.app.repository.os.ServiceOSRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOSService())
				.builder();
	}
	
	@Test
	public void deveSalvarUmServiceOS() {

		serviceOSService.save(coletaResultado);
		verify(serviceOSRepository).save(Mockito.any(ServiceOS.class));
	}
	
	@Test
	public void deveConstruirServiceOS() {
		
		ServiceOS serviceOS = new ServiceOSBuilder(coletaResultado).builder();
		Assertions.assertNotNull(serviceOS);
		Assertions.assertEquals(coletaResultado.getId(), serviceOS.getId());
		Assertions.assertNotNull(serviceOS.getOsService());
		Assertions.assertFalse(serviceOS.getOsService().isEmpty());;
		
		OSService osService = serviceOS.getOsService().get(0);
		Assertions.assertEquals("teste1", osService.getName());
		Assertions.assertEquals(213, osService.getProcessID());
		Assertions.assertEquals(State.RUNNING, osService.getState());
	
	}
}
