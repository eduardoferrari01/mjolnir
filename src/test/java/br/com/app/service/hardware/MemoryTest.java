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
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.domain.hardware.Memory;
import br.com.app.repository.hardware.MemoryRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class MemoryTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private MemoryService memoryService;
	@Mock
	private MemoryRepository memoryRepository;  
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadMemory()).builder();
	}
	
	@Test
	public void deveSalvarUmMemory() throws IOException {

		memoryService.save(coletaResultado);
		verify(memoryRepository).save(Mockito.any(Memory.class));
	}
}
