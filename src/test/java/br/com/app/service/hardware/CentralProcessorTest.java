package br.com.app.service.hardware;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.repository.hardware.CentralProcessorRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class CentralProcessorTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private CentralProcessorService centralProcessorService;
	@Mock
	private CentralProcessorRepository centralProcessorRepository;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadProcessor()).builder();
	}
	
	@Test
	public void deveSalvarUmCentralProcessor() {

		centralProcessorService.save(coletaResultado);
		verify(centralProcessorRepository).save(Mockito.any(CentralProcessor.class));
	}
	
	@Test
	public void deveRetornarUmCentralProcessor() {
 
		CentralProcessor centralProcessorEsperado = new CentralProcessorBuilder(coletaResultado).builder();
		
		when(centralProcessorRepository.findById(coletaResultado.getId())).thenReturn(Optional.of(new CentralProcessorBuilder(coletaResultado).builder()));
		
		CentralProcessor centralProcessorRetorno = centralProcessorService.findById(coletaResultado.getId());
		verify(centralProcessorRepository).findById(coletaResultado.getId());
		
		Assertions.assertEquals(centralProcessorRetorno.getId(), centralProcessorEsperado.getId());
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			centralProcessorService.findById("123");
		});
	}
	
}
