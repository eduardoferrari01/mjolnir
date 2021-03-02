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
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.repository.os.OSVersionInfoRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileOSJson;

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
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadFileOSJson.loadOSVersionInfo())
				.builder();
	}
	
	@Test
	public void deveSalvarUmOSVersionInfo() {

		osVersionInfoService.save(coletaResultado);
		verify(osVersionInfoRepository).save(Mockito.any(OSVersionInfo.class));
	}
	
}