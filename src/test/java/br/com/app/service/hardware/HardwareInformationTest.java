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
	private static String ID  = "";
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultadoComputerSystem = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadComputerSystem()).builder();
		coletaResultadoCentralProcessor = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadProcessor()).builder();
		coletaResultadoDisplays = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadDisplays()).builder();
		ID = coletaResultadoCentralProcessor.getId();
	}
	
	@Test
	public void deveRetornarUmHardwareInformation() {
 
		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultadoComputerSystem).builder();
		CentralProcessor centralProcessor = new CentralProcessorBuilder(coletaResultadoCentralProcessor).builder();
		Displays displays = new DisplaysBuilder(coletaResultadoDisplays).builder();
		
		HardwareInformation hardwareInformation = new HardwareInformationBuilder(computerSystem, centralProcessor, displays).builderToDto();
		
		when(computerSystemService.findById(ID)).thenReturn(computerSystem);
		when(centralProcessorService.findById(ID)).thenReturn(centralProcessor);
		when(displaysService.findById(ID)).thenReturn(displays);
		
		HardwareInformation hardwareInformationFind = hardwareInformationService.findById(ID);
		
		verify(computerSystemService).findById(ID);
		verify(centralProcessorService).findById(ID);
		verify(displaysService).findById(ID);
		
		Assertions.assertEquals(hardwareInformationFind, hardwareInformation);
	}
	
	@Test
	public void deveCriarUmHardwareInformation() {
		
		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultadoComputerSystem).builder();
		CentralProcessor centralProcessor = new CentralProcessorBuilder(coletaResultadoCentralProcessor).builder();
		Displays displays = new DisplaysBuilder(coletaResultadoDisplays).builder();
		
		HardwareInformation hardwareInformation = new HardwareInformationBuilder(computerSystem, centralProcessor, displays).builderToDto();
		
		Assertions.assertEquals(hardwareInformation.getManufacturer(), computerSystem.getManufacturer());
		Assertions.assertEquals(hardwareInformation.getModel(), computerSystem.getModel());
		Assertions.assertEquals(hardwareInformation.getSerialNumber(), computerSystem.getSerialNumber());
		
		Assertions.assertEquals(hardwareInformation.getFirmwareManufacturer(), computerSystem.getFirmware().getManufacturer());
		Assertions.assertEquals(hardwareInformation.getFirmwareName(), computerSystem.getFirmware().getName());
		Assertions.assertEquals(hardwareInformation.getFirmwareDescription(), computerSystem.getFirmware().getDescription());
		Assertions.assertEquals(hardwareInformation.getFirmwareVersion(),  computerSystem.getFirmware().getVersion());
		Assertions.assertEquals(hardwareInformation.getFirmwareReleaseDate(), computerSystem.getFirmware().getReleaseDate());
		
		Assertions.assertEquals(hardwareInformation.getBaseboardManufacturer(), computerSystem.getBaseboard().getManufacturer());
		Assertions.assertEquals(hardwareInformation.getBaseboardModel(), computerSystem.getBaseboard().getModel());
		Assertions.assertEquals(hardwareInformation.getBaseboardVersion(), computerSystem.getBaseboard().getVersion());
		Assertions.assertEquals(hardwareInformation.getBaseboardSerialNumber(), computerSystem.getBaseboard().getSerialNumber());
		
		Assertions.assertEquals(hardwareInformation.getProcessorName(), centralProcessor.getProcessorIdentifier().getName());
		Assertions.assertEquals(hardwareInformation.getProcessorIdentifier(), centralProcessor.getProcessorIdentifier().getIdentifier());
		Assertions.assertEquals(hardwareInformation.getProcessorID(), centralProcessor.getProcessorIdentifier().getProcessorID());
		Assertions.assertEquals(hardwareInformation.getProcessorMicroarchitecture(), centralProcessor.getProcessorIdentifier().getMicroarchitecture());
		Assertions.assertEquals(hardwareInformation.getProcessorPhysicalPackageCount(), centralProcessor.getPhysicalPackageCount());
		Assertions.assertEquals(hardwareInformation.getProcessorPhysicalProcessorCount(), centralProcessor.getPhysicalProcessorCount());
		Assertions.assertEquals(hardwareInformation.getProcessorLogicalProcessorCount(), centralProcessor.getLogicalProcessorCount());
		
		List<String> hardwareInformationDisplays = hardwareInformation.getDisplays();
		
		List<String> displaysFind = new ArrayList<>();
		
		displays.getDisplays().forEach(display -> {

			displaysFind.addAll(display.getEdid());
		});
		 
		Assertions.assertEquals( hardwareInformationDisplays, displaysFind);
		
	 }
	
}
