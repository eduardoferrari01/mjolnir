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
import br.com.app.domain.os.Processe;
import br.com.app.repository.os.ProcesseRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class ProcesseTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private ProcesseService processeService;
	@Mock
	private ProcesseRepository processeRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOSProcess())
				.builder();
	}
	
	@Test
	public void deveSalvarUmProcesse() {

		processeService.save(coletaResultado);
		verify(processeRepository).save(Mockito.any(Processe.class));
	}
}
