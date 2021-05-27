package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.PowerSourcesBuilder;
import br.com.app.domain.enums.CapacityUnits;
import br.com.app.domain.hardware.PowerSource;
import br.com.app.domain.hardware.PowerSources;
import br.com.app.repository.hardware.PowerSourcesRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class PowerSourcesTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private PowerSourcesService powerSourcesService;
	@Mock
	private PowerSourcesRepository powerSourcesRepository;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadPowerSources()).builder();
	}
	
	@Test
	public void deveSalvarUmPowerSources() throws IOException {

		powerSourcesService.save(coletaResultado);
		verify(powerSourcesRepository).save(Mockito.any(PowerSources.class));
	}
	
	@Test
	public void deveRetornarUmPowerSources(){
	
		PowerSources powerSources = new PowerSourcesBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(powerSources);
		Assertions.assertEquals(coletaResultado.getId(), powerSources.getId());
		Assertions.assertFalse(powerSources.getPowerSources().isEmpty());
	
		PowerSource powerSource = powerSources.getPowerSources().get(0);
		Assertions.assertEquals("hidpp_battery_0", powerSource.getName());
		Assertions.assertEquals("Wireless Keyboard", powerSource.getDeviceName());
		Assertions.assertEquals(-1.0, powerSource.getRemainingCapacityPercent());
		Assertions.assertEquals(-1.0, powerSource.getTimeRemainingEstimated());
		Assertions.assertEquals(-1.0, powerSource.getTimeRemainingInstant());
		Assertions.assertEquals(0.0, powerSource.getPowerUsageRate());
		Assertions.assertEquals(-1.0, powerSource.getVoltage());
		Assertions.assertEquals(0.0, powerSource.getAmperage());
		Assertions.assertEquals(Boolean.FALSE, powerSource.getPowerOnLine());
		Assertions.assertEquals(Boolean.FALSE, powerSource.getCharging());
		Assertions.assertEquals(Boolean.TRUE, powerSource.getDischarging());
		Assertions.assertEquals(CapacityUnits.RELATIVE, powerSource.getCapacityUnits());
		Assertions.assertEquals(-1, powerSource.getCurrentCapacity());
		Assertions.assertEquals(-1, powerSource.getMaxCapacity());
		Assertions.assertEquals(-1, powerSource.getDesignCapacity());
		Assertions.assertEquals(-1, powerSource.getCycleCount());
		Assertions.assertEquals("unknown", powerSource.getChemistry());
		Assertions.assertEquals(LocalDate.of(2021, 02, 01), powerSource.getManufactureDate());
		Assertions.assertEquals("Logitech", powerSource.getManufacturer());
		Assertions.assertEquals("4023-00-00-00-00", powerSource.getSerialNumber());
		Assertions.assertEquals(0.0, powerSource.getTemperature());
	}
	
}
