package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.MemoryBuilder;
import br.com.app.domain.hardware.Memory;
import br.com.app.repository.hardware.MemoryRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadMemory()).builder();
	}
	
	@Test
	public void deveSalvarUmMemory() throws IOException {

		memoryService.save(coletaResultado);
		verify(memoryRepository).save(Mockito.any(Memory.class));
	}
	
	@Test
	public void deveCriarUmMemory() {
		
		Memory memory = new MemoryBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(memory);
		Assertions.assertEquals(coletaResultado.getId(), memory.getId());
		Assertions.assertEquals(8038240256L, memory.getTotal());
		Assertions.assertEquals(2298691584L, memory.getAvailable());
		Assertions.assertEquals(4096L, memory.getPageSize());
		Assertions.assertNotNull(memory.getVirtualMemory());
		Assertions.assertEquals(8450203648L ,memory.getVirtualMemory().getSwapTotal());
		Assertions.assertEquals(4194304L ,memory.getVirtualMemory().getSwapUsed());
		Assertions.assertEquals(12469321728L ,memory.getVirtualMemory().getVirtualMax());
		Assertions.assertEquals(5743742976L ,memory.getVirtualMemory().getVirtualInUse());
		Assertions.assertEquals(0 ,memory.getVirtualMemory().getSwapPagesIn());
		Assertions.assertEquals(8168L ,memory.getVirtualMemory().getSwapPagesOut());
		Assertions.assertNotNull(memory.getPhysicalMemory());
	}
}
