package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.builder.hardware.ComputerSystemBuilder;
import br.com.app.domain.builder.hardware.DisplaysBuilder;
import br.com.app.domain.builder.hardware.HardwareInformationBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.Displays;
import br.com.app.dto.HardwareInformation;
import br.com.app.repository.hardware.CentralProcessorRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class HardwareInformationTest {

	private static ColetaResultado coletaResultadoComputerSystem;
	private static ColetaResultado coletaResultadoCentralProcessor;
	private static ColetaResultado coletaResultadoDisplays;
	@InjectMocks
	private HardwareInformationService hardwareInformationService;
	@Mock
	private CentralProcessorRepository centralProcessorRepository;
	@Mock
	private ComputerSystemService computerSystemService;
	@Mock
	private CentralProcessorService centralProcessorService;
	@Mock
	private DisplaysService displaysService;
	private static String ID = "";
	private static ComputerSystem computerSystem;
	private static CentralProcessor centralProcessor;
	private static Displays displays;

	@BeforeAll
	public static void setup() {

		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultadoComputerSystem = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadComputerSystem()).builder();
		coletaResultadoCentralProcessor = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadProcessor()).builder();
		coletaResultadoDisplays = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadDisplays()).builder();
		computerSystem = new ComputerSystemBuilder(coletaResultadoComputerSystem).builder();
		centralProcessor = new CentralProcessorBuilder(coletaResultadoCentralProcessor).builder();
		displays = new DisplaysBuilder(coletaResultadoDisplays).builder();
		ID = coletaResultadoCentralProcessor.getId();
	}

	@Test
	public void deveRetornarUmHardwareInformation() {

		when(computerSystemService.findById(ID)).thenReturn(computerSystem);
		when(centralProcessorService.findById(ID)).thenReturn(centralProcessor);
		when(displaysService.findById(ID)).thenReturn(displays);

		HardwareInformation hardwareInformationActual = hardwareInformationService.findById(ID);

		verify(computerSystemService).findById(ID);
		verify(centralProcessorService).findById(ID);
		verify(displaysService).findById(ID);

		validateHardwareInformation(hardwareInformationActual);
	}

	@Test
	public void deveConstruirHardwareInformation() {

		HardwareInformation hardwareInformation = new HardwareInformationBuilder(computerSystem, centralProcessor,
				displays).builderToDto();
		
		validateHardwareInformation(hardwareInformation);

	}

	private void validateHardwareInformation(HardwareInformation hardwareInformation) {

		Assertions.assertEquals(computerSystem.getManufacturer(), hardwareInformation.getManufacturer());
		Assertions.assertEquals(computerSystem.getModel(), hardwareInformation.getModel());
		Assertions.assertEquals(computerSystem.getSerialNumber(), hardwareInformation.getSerialNumber());
		Assertions.assertEquals(computerSystem.getFirmware().getManufacturer(), hardwareInformation.getFirmwareManufacturer());
		Assertions.assertEquals(computerSystem.getFirmware().getName(), hardwareInformation.getFirmwareName());
		Assertions.assertEquals(computerSystem.getFirmware().getDescription(), hardwareInformation.getFirmwareDescription());
		Assertions.assertEquals(computerSystem.getFirmware().getVersion(), hardwareInformation.getFirmwareVersion());
		Assertions.assertEquals(computerSystem.getFirmware().getReleaseDate(), hardwareInformation.getFirmwareReleaseDate());
		Assertions.assertEquals(computerSystem.getBaseboard().getManufacturer(), hardwareInformation.getBaseboardManufacturer());
		Assertions.assertEquals(computerSystem.getBaseboard().getModel(), hardwareInformation.getBaseboardModel());
		Assertions.assertEquals(computerSystem.getBaseboard().getVersion(), hardwareInformation.getBaseboardVersion());
		Assertions.assertEquals(computerSystem.getBaseboard().getSerialNumber(), hardwareInformation.getBaseboardSerialNumber());
		Assertions.assertEquals(centralProcessor.getProcessorIdentifier().getName() ,hardwareInformation.getProcessorName());
		Assertions.assertEquals(centralProcessor.getProcessorIdentifier().getIdentifier() , hardwareInformation.getProcessorIdentifier());
		Assertions.assertEquals(centralProcessor.getProcessorIdentifier().getProcessorID(), hardwareInformation.getProcessorID());
		Assertions.assertEquals(centralProcessor.getProcessorIdentifier().getMicroarchitecture(), hardwareInformation.getProcessorMicroarchitecture());
		Assertions.assertEquals(centralProcessor.getPhysicalPackageCount(),hardwareInformation.getProcessorPhysicalPackageCount());
		Assertions.assertEquals(centralProcessor.getPhysicalProcessorCount(), hardwareInformation.getProcessorPhysicalProcessorCount());
		Assertions.assertEquals(centralProcessor.getLogicalProcessorCount(), hardwareInformation.getProcessorLogicalProcessorCount());

		List<String> hardwareInformationDisplays = hardwareInformation.getDisplays();

		List<String> displaysExpected = new ArrayList<>();

		displays.getDisplays().forEach(display -> {

			displaysExpected.addAll(display.getEdid());
		});

		Assertions.assertEquals(displaysExpected, hardwareInformationDisplays);

	}
}
