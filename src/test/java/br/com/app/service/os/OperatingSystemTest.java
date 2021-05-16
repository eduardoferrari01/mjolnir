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
import br.com.app.domain.builder.os.OperatingSystemBuilder;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.repository.os.OperatingSystemRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class OperatingSystemTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private OperatingSystemService operatingSystemService;
	@Mock
	private OperatingSystemRepository operatingSystemRepository;

	@BeforeAll
	public static void setup() {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOperatingSystem()).builder();
	}

	@Test
	public void deveSalvarUmOperatingSystem() {

		operatingSystemService.save(coletaResultado);
		verify(operatingSystemRepository).save(Mockito.any(OperatingSystem.class));
	}

	@Test
	public void deveConstruirOperatingSystem() {

		OperatingSystem operatingSystem = new OperatingSystemBuilder(coletaResultado).builder();

		Assertions.assertNotNull(operatingSystem);
		Assertions.assertEquals(coletaResultado.getId(), operatingSystem.getId());
		Assertions.assertEquals(64, operatingSystem.getBitness());
		Assertions.assertEquals("Manjaro Linux", operatingSystem.getFamily());
		Assertions.assertEquals("GNU/Linux", operatingSystem.getManufacturer());
		Assertions.assertEquals(300, operatingSystem.getProcessCount());
		Assertions.assertEquals(21549, operatingSystem.getProcessId());
		Assertions.assertEquals(1614434100L, operatingSystem.getSystemBootTime());
		Assertions.assertEquals(8399L, operatingSystem.getSystemUptime());
		Assertions.assertEquals(990, operatingSystem.getThreadCount());
		Assertions.assertEquals("02:19:59", operatingSystem.getHourUpTime());
		Assertions.assertEquals(0L, operatingSystem.getDayUptTime());
	}

	@Test
	public void deveRetornarUmOperatingSystem() {

		String ID = coletaResultado.getId();

		OperatingSystem operatingSystemExpected = new OperatingSystemBuilder(coletaResultado).builder();

		when(operatingSystemRepository.findById(ID))
				.thenReturn(Optional.of(new OperatingSystemBuilder(coletaResultado).builder()));

		OperatingSystem operatingSystemActual = operatingSystemService.findById(ID);
		verify(operatingSystemRepository).findById(coletaResultado.getId());

		Assertions.assertNotNull(operatingSystemActual);

		Assertions.assertEquals(operatingSystemActual.getId(), operatingSystemExpected.getId());
		Assertions.assertEquals(operatingSystemActual.getBitness(), operatingSystemExpected.getBitness());
		Assertions.assertEquals(operatingSystemActual.getProcessCount(), operatingSystemExpected.getProcessCount());
		Assertions.assertEquals(operatingSystemActual.getDayUptTime(), operatingSystemExpected.getDayUptTime());
		Assertions.assertEquals(operatingSystemActual.getBootTime(), operatingSystemExpected.getBootTime());
		Assertions.assertEquals(operatingSystemActual.getProcessId(), operatingSystemExpected.getProcessId());
		Assertions.assertEquals(operatingSystemActual.getSystemBootTime(), operatingSystemExpected.getSystemBootTime());
		Assertions.assertEquals(operatingSystemActual.getSystemUptime(), operatingSystemExpected.getSystemUptime());
		Assertions.assertEquals(operatingSystemActual.getFamily(), operatingSystemExpected.getFamily());
		Assertions.assertEquals(operatingSystemActual.getDayUptTime(), operatingSystemExpected.getDayUptTime());
		Assertions.assertEquals(operatingSystemActual.getHourUpTime(), operatingSystemExpected.getHourUpTime());
		Assertions.assertEquals(operatingSystemActual.getManufacturer(), operatingSystemExpected.getManufacturer());
		
	}
	
	@Test
	public void testEquals() {
		
		OperatingSystem operatingSystem1 = new OperatingSystemBuilder(coletaResultado).builder();
		OperatingSystem operatingSystem2 = new OperatingSystemBuilder(coletaResultado).builder();
		
		Assertions.assertEquals(operatingSystem1, operatingSystem1);
		Assertions.assertEquals(operatingSystem1, operatingSystem2);
		
		operatingSystem2.setId("123BBBBBXXXXAAA");
		Assertions.assertNotEquals(operatingSystem1, operatingSystem2);
		
		operatingSystem1.setId(null);
		Assertions.assertNotEquals(operatingSystem1, operatingSystem2);
		Assertions.assertNotEquals(operatingSystem1, new OSVersionInfo());
		Assertions.assertNotEquals(operatingSystem1, null);
	}

	@Test
	public void testHashCode() {
		
		OperatingSystem operatingSystem1 = new OperatingSystemBuilder(coletaResultado).builder();
		OperatingSystem operatingSystem2 = new OperatingSystemBuilder(coletaResultado).builder();
		
		Assertions.assertEquals(operatingSystem1.hashCode(), operatingSystem2.hashCode()); 
		operatingSystem1.setId(null);
		Assertions.assertNotEquals(operatingSystem1.hashCode(), operatingSystem2.hashCode()); 
	}
	
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {

		assertThrows(NotFoundException.class, () -> {
			operatingSystemService.findById("123");
		});
	}
}
