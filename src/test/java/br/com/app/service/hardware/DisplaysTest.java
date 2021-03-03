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
import br.com.app.domain.hardware.Displays;
import br.com.app.repository.hardware.DisplaysRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class DisplaysTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private DisplaysService displaysService;
	@Mock
	private DisplaysRepository displaysRepository; 
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadDisplays()).builder();
	}
	
	@Test
	public void deveSalvarUmDisplays() throws IOException {

		displaysService.save(coletaResultado);
		verify(displaysRepository).save(Mockito.any(Displays.class));
	}
	
}
