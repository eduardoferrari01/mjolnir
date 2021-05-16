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
		
		OSVersionInfo osVersionInfoExpected = new OSVersionInfoBuilder(coletaResultado).builder();
		
		when(osVersionInfoRepository.findById(ID))
				.thenReturn(Optional.of(new OSVersionInfoBuilder(coletaResultado).builder()));
		
		OSVersionInfo osVersionInfoActual = osVersionInfoService.findById(ID);
		verify(osVersionInfoRepository).findById(coletaResultado.getId());
		
		Assertions.assertEquals(osVersionInfoExpected.getId(),osVersionInfoActual.getId());
		Assertions.assertEquals(osVersionInfoExpected.getBuildNumber(),osVersionInfoActual.getBuildNumber());
		Assertions.assertEquals(osVersionInfoExpected.getCodeName(),osVersionInfoActual.getCodeName());
		Assertions.assertEquals(osVersionInfoExpected.getVersion(),osVersionInfoActual.getVersion());
		Assertions.assertEquals(osVersionInfoExpected.getVersionInfo(),osVersionInfoActual.getVersionInfo());
		Assertions.assertEquals(osVersionInfoExpected.getVersionStr(),osVersionInfoActual.getVersionStr());
	}
	
	@Test
	public void deveConstruirOSVersionInfo() {

		OSVersionInfo osVersionInfo = new OSVersionInfoBuilder(coletaResultado).builder();

		Assertions.assertNotNull(osVersionInfo);
		Assertions.assertEquals(coletaResultado.getId(), osVersionInfo.getId());
		Assertions.assertEquals("5.10.15-1-MANJARO", osVersionInfo.getBuildNumber());
		Assertions.assertEquals("unknown", osVersionInfo.getCodeName());
		Assertions.assertEquals("unknown", osVersionInfo.getVersion());
		Assertions.assertEquals("unknown unknown 5.10.15-1-MANJARO", osVersionInfo.getVersionInfo());
		Assertions.assertEquals(null, osVersionInfo.getVersionStr());
	}
	
	@Test
	public void testEquals() {
		
		OSVersionInfo osVersionInfo1 = new OSVersionInfoBuilder(coletaResultado).builder();
		OSVersionInfo osVersionInfo2 = new OSVersionInfoBuilder(coletaResultado).builder();
		
		Assertions.assertEquals(osVersionInfo1, osVersionInfo1);
		Assertions.assertEquals(osVersionInfo1, osVersionInfo2);
		
		osVersionInfo2.setId("11111199999");
		Assertions.assertNotEquals(osVersionInfo1, osVersionInfo2);
		
		osVersionInfo1.setId(null);
		Assertions.assertNotEquals(osVersionInfo1, osVersionInfo2);
		Assertions.assertNotEquals(osVersionInfo1, new OperatingSystem());
		Assertions.assertNotEquals(osVersionInfo1, null);
	}

	@Test
	public void testHashCode() {
		
		OSVersionInfo osVersionInfo1 = new OSVersionInfoBuilder(coletaResultado).builder();
		OSVersionInfo osVersionInfo2 = new OSVersionInfoBuilder(coletaResultado).builder();
		
		Assertions.assertEquals(osVersionInfo1.hashCode(), osVersionInfo2.hashCode()); 
		osVersionInfo1.setId(null);
		Assertions.assertNotEquals(osVersionInfo1.hashCode(), osVersionInfo2.hashCode()); 
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			osVersionInfoService.findById("123");
		});
	}
	
	
}