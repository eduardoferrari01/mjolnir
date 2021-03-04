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
import br.com.app.domain.os.OperatingSystem;
import br.com.app.repository.os.OperatingSystemRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class OperatingSystemTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private OperatingSystemService operatingSystemService;
	@Mock
	private OperatingSystemRepository operatingSystemRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOperatingSystem())
				.builder();
	}
	
	@Test
	public void deveSalvarUmOperatingSystem() {

		operatingSystemService.save(coletaResultado);
		verify(operatingSystemRepository).save(Mockito.any(OperatingSystem.class));
	}
	
}
