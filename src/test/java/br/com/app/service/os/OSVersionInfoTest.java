package br.com.app.service.os;

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
import br.com.app.domain.builder.os.OSVersionInfoBuilder;
import br.com.app.domain.builder.os.OperatingSystemBuilder;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.repository.os.OSVersionInfoRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class OSVersionInfoTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private OSVersionInfoService osVersionInfoService;
	@Mock
	private OSVersionInfoRepository osVersionInfoRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOSVersionInfo())
				.builder();
	}
	
	@Test
	public void deveSalvarUmOSVersionInfo() {

		osVersionInfoService.save(coletaResultado);
		verify(osVersionInfoRepository).save(Mockito.any(OSVersionInfo.class));
	}
	
	@Test
	public void deveRetornarOSVersionInfo() {
		
		String ID = coletaResultado.getId();
		
		OSVersionInfo osVersionInfo = new OSVersionInfoBuilder(coletaResultado).builder();
		
		when(osVersionInfoRepository.findById(ID))
				.thenReturn(Optional.of(new OSVersionInfoBuilder(coletaResultado).builder()));
		
		OSVersionInfo osVersionInfoFind = osVersionInfoService.findById(ID);
		verify(osVersionInfoRepository).findById(coletaResultado.getId());
		
		Assertions.assertEquals(osVersionInfoFind, osVersionInfo);
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			osVersionInfoService.findById("123");
		});
	}
	
	
}