package br.com.app.service.os;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.OSVersionInfoBuilder;
import br.com.app.domain.builder.os.OperatingSystemBuilder;
import br.com.app.domain.builder.os.OperatingSystemInformationBuilder;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.dto.os.OperatingSystemInformation;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class OperatingSystemInformationTest {

	private static ColetaResultado coletaResultadoOsVersionInfo;
	private static ColetaResultado coletaResultadoOperatingSystem;
	@InjectMocks
	private OperatingSystemInformationService operatingSystemInformationService;
	@Mock
	private OSVersionInfoService osVersionInfoService;
	@Mock
	private OperatingSystemService operatingSystemService;
	private static String ID = "";
	private static OSVersionInfo osVersionInfo;
	private static OperatingSystem operatingSystem;
	
	
	@BeforeAll
	public static void setup() {

		LoadFileOSJson loadJson = new LoadFileOSJson();
		coletaResultadoOsVersionInfo = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadOSVersionInfo()).builder();
		coletaResultadoOperatingSystem = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadOperatingSystem()).builder();
		
		ID = coletaResultadoOperatingSystem.getId();
		osVersionInfo = new OSVersionInfoBuilder(coletaResultadoOsVersionInfo).builder();
		operatingSystem = new OperatingSystemBuilder(coletaResultadoOperatingSystem).builder();
	}

	@Test
	public void deveConstruirOperatingSystemInformation() {

		OperatingSystemInformation operatingSystemInformation = new OperatingSystemInformationBuilder(osVersionInfo,
				operatingSystem).builderToDto();
		
		validateHardwareInformation(operatingSystemInformation);
	}

	@Test
	public void deveRetornarUmOperatingSystemInformation() {
	
		OSVersionInfo osVersionInfo = new OSVersionInfoBuilder(coletaResultadoOsVersionInfo).builder();
		OperatingSystem operatingSystem = new OperatingSystemBuilder(coletaResultadoOperatingSystem).builder();

		when(operatingSystemService.findById(ID)).thenReturn(operatingSystem);
		when(osVersionInfoService.findById(ID)).thenReturn(osVersionInfo);
		
		OperatingSystemInformation operatingSystemInformationActual = operatingSystemInformationService.findById(ID);
		
		verify(osVersionInfoService).findById(ID);
		verify(operatingSystemService).findById(ID);
		
		validateHardwareInformation(operatingSystemInformationActual);
		
	}
	
	private void validateHardwareInformation(OperatingSystemInformation osInformation) {
		
		Assertions.assertEquals(operatingSystem.getManufacturer(), osInformation.getManufacturer());
		Assertions.assertEquals(operatingSystem.getFamily(), osInformation.getFamily());
		Assertions.assertEquals(operatingSystem.getBitness(), osInformation.getBitness());
		Assertions.assertEquals(operatingSystem.getDayUptTime(), osInformation.getDayUptTime());
		Assertions.assertEquals(operatingSystem.getHourUpTime(), osInformation.getHourUpTime());
		Assertions.assertEquals(operatingSystem.getBootTime(), osInformation.getBootTime());
		Assertions.assertEquals(osVersionInfo.getVersionInfo(), osInformation.getVersionInfo());
	}
}
