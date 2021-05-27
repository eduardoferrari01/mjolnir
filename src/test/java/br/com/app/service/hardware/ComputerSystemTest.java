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
import br.com.app.domain.builder.hardware.ComputerSystemBuilder;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.repository.hardware.ComputerSystemRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadComputerSystem()).builder();
	}
	
	@Test
	public void deveSalvarUmComputerSystem() throws IOException {

		computerSystemService.save(coletaResultado);
		verify(computerSystemRepository).save(Mockito.any(ComputerSystem.class));
	}
	
	@Test
	public void deveRetornarUmComputerSystem() {

		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultado).builder();

		when(computerSystemRepository.findById(coletaResultado.getId())).thenReturn(Optional.of(new ComputerSystemBuilder(coletaResultado).builder()));

		ComputerSystem computerSystemRetorno = computerSystemService.findById(coletaResultado.getId());
		verify(computerSystemRepository).findById(coletaResultado.getId());

		Assertions.assertEquals(computerSystemRetorno.getId(), computerSystem.getId());
	}
	
	@Test
	public void deveConstruirComputerSystem() {

		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultado).builder();

		Assertions.assertEquals("System manufacturer", computerSystem.getManufacturer());
		Assertions.assertEquals("System Product Name (version: System Version)", computerSystem.getModel());
		Assertions.assertEquals("unknown", computerSystem.getSerialNumber());
		Assertions.assertEquals("unknown", computerSystem.getHardwareUUID());
		Assertions.assertEquals("unknown", computerSystem.getFirmware().getManufacturer());
		Assertions.assertEquals("unknown", computerSystem.getFirmware().getName());
		Assertions.assertEquals("dmi:bvnAmericanMegatrendsInc.", computerSystem.getFirmware().getDescription());
		Assertions.assertEquals("4307", computerSystem.getFirmware().getVersion());
		Assertions.assertEquals("2013-05-13", computerSystem.getFirmware().getReleaseDate());
		Assertions.assertEquals("ASUSTeK COMPUTER INC.", computerSystem.getBaseboard().getManufacturer());
		Assertions.assertEquals("P8H61-M LE/BR", computerSystem.getBaseboard().getModel());
		Assertions.assertEquals("Rev x.0x", computerSystem.getBaseboard().getVersion());
		Assertions.assertEquals("unknown", computerSystem.getBaseboard().getSerialNumber());
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			computerSystemService.findById("123");
		});
	}
	
}
