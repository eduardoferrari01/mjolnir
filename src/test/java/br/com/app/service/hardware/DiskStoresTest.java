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
import br.com.app.domain.hardware.Disks;
import br.com.app.repository.hardware.DisksRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class DiskStoresTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private DisksService disksService;
	@Mock
	private DisksRepository disksRepository; 
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadDisks()).builder();
	}
	
	@Test
	public void deveSalvarUmDisks() throws IOException {

		disksService.save(coletaResultado);
		verify(disksRepository).save(Mockito.any(Disks.class));
	}
}
