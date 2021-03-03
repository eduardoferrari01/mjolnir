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
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.repository.hardware.ComputerSystemRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class ComputerSystemTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private ComputerSystemService computerSystemService;
	@Mock
	private ComputerSystemRepository computerSystemRepository; 
	
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadComputerSystem()).builder();
	}
	
	@Test
	public void deveSalvarUmComputerSystem() throws IOException {

		computerSystemService.save(coletaResultado);
		verify(computerSystemRepository).save(Mockito.any(ComputerSystem.class));
	}
}
