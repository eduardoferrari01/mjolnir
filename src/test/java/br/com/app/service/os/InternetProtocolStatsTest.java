package br.com.app.service.os;

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
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.repository.os.InternetProtocolStatsRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class InternetProtocolStatsTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private InternetProtocolStatsService internetProtocolStatsService;
	@Mock
	private InternetProtocolStatsRepository internetProtocolStatsRepository;
	 
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadFileOSJson.loadInternetProtocolStats())
				.builder();
	}

	@Test
	public void deveSalvarUmInternetProtocolStats() throws IOException {

		internetProtocolStatsService.save(coletaResultado);
		verify(internetProtocolStatsRepository).save(Mockito.any(InternetProtocolStats.class));
	}
}
