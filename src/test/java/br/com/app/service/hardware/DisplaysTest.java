package br.com.app.service.hardware;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.NotFoundException;
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.builder.hardware.DisplaysBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.Displays;
import br.com.app.repository.hardware.DisplaysRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadDisplays()).builder();
	}
	
	@Test
	public void deveSalvarUmDisplays() throws IOException {

		displaysService.save(coletaResultado);
		verify(displaysRepository).save(Mockito.any(Displays.class));
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			displaysService.findById("123");
		});
	}
	
	@Test
	public void deveRetornarUmDisplays() {
 
		Displays displays = new DisplaysBuilder(coletaResultado).builder();
		
		when(displaysRepository.findById(coletaResultado.getId())).thenReturn(Optional.of(new DisplaysBuilder(coletaResultado).builder()));
		
		Displays displaysRetorno = displaysService.findById(coletaResultado.getId());
		verify(displaysRepository).findById(coletaResultado.getId());
		
		Assertions.assertEquals(displaysRetorno.getId(), displays.getId());
	}
	
}
