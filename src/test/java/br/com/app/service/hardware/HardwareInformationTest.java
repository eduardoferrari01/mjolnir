package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
}
