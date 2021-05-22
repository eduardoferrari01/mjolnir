package br.com.app.service.hardware;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
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
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.LogicalProcessors;
import br.com.app.domain.hardware.ProcessorIdentifier;
import br.com.app.repository.hardware.CentralProcessorRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class CentralProcessorTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private CentralProcessorService centralProcessorService;
	@Mock
	private CentralProcessorRepository centralProcessorRepository;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadProcessor()).builder();
	}
	
	@Test
	public void deveSalvarUmCentralProcessor() {

		centralProcessorService.save(coletaResultado);
		verify(centralProcessorRepository).save(Mockito.any(CentralProcessor.class));
	}
	
	@Test
	public void deveRetornarUmCentralProcessor() {
 
		when(centralProcessorRepository.findById(coletaResultado.getId())).thenReturn(Optional.of(new CentralProcessorBuilder(coletaResultado).builder()));
		
		CentralProcessor centralProcessor = centralProcessorService.findById(coletaResultado.getId());
		verify(centralProcessorRepository).findById(coletaResultado.getId());
		
		validateCentralProcessor(centralProcessor);
		validateLogicalProcessors(centralProcessor.getLogicalProcessors());
		validateProcessorIdentifier(centralProcessor.getProcessorIdentifier());
	}
	
	@Test
	public void deveConstruirCentralProcessor(){
		
		CentralProcessor centralProcessor = new CentralProcessorBuilder(coletaResultado).builder();
		validateCentralProcessor(centralProcessor);
		validateLogicalProcessors(centralProcessor.getLogicalProcessors());
		validateProcessorIdentifier(centralProcessor.getProcessorIdentifier());
	}
	
	private void validateCentralProcessor(CentralProcessor processor) {
		
		Assertions.assertNotNull(processor);
		Assertions.assertEquals(coletaResultado.getId(), processor.getId());
		Assertions.assertEquals(378725741L, processor.getContextSwitches());
		Assertions.assertEquals(101401698L, processor.getInterrupts());
		Assertions.assertEquals(4, processor.getLogicalProcessorCount());
		Assertions.assertEquals(3400000000L, processor.getMaxFreq());
		Assertions.assertEquals(1, processor.getPhysicalPackageCount());
		Assertions.assertEquals(4, processor.getPhysicalProcessorCount());

		validateList(Arrays.asList(3162660000L, 3013177000L, 2929436000L, 2892862000L), processor.getCurrentFreq());
		validateList(Arrays.asList(22291440L, 13740L, 6858880L, 310385380L, 377370L, 530210L, 392830L, 0L),
				processor.getSystemCpuLoadTicks());
		
		Long [][] processorCpuLoadTicksExpected = createMatriz();
	 
		validateMatriz(processorCpuLoadTicksExpected, processor.getProcessorCpuLoadTicks());
	}

	private Long [][] createMatriz() {
		
		Long[][] matriz = { { 5332910L, 3650L, 1648780L, 77885600L, 70800L, 135140L, 131480L, 0L },
				{ 5701220L, 3420L, 1742170L, 77534770L, 64620L, 106940L, 73240L, 0L },
				{ 5671730L, 3420L, 1742380L, 77450200L, 161840L, 112540L, 85590L, 0L },
				{ 5585570L, 3240L, 1725540L, 77514790L, 80090L, 175570L, 102510L, 0L } };
		
		return matriz;
	}
	
	private void validateList(List<Long> expected, List<Long> actual) {

		Assertions.assertNotNull(actual);
		Assertions.assertFalse(actual.isEmpty());
		Assertions.assertEquals(expected, actual);
	}
	
	private void validateMatriz(Long[][] expected, Long[][] actual) {

		Assertions.assertNotNull(actual);
		Assertions.assertTrue(matrizEquals(expected, actual));
	}
	
	private boolean matrizEquals(Long[][] matriz1, Long[][] matriz2) {
		
		if(matriz1.length != matriz2.length)
			return false;
		
		int rowSize = matriz1.length;
		int columnSize =  matriz1[0].length;
		
		for(int row  = 0 ; row < rowSize; row++) {
			
			for(int column = 0 ; column < columnSize; column++) {
				
				if(!matriz1[row][column].equals(matriz2[row][column])) {
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void validateLogicalProcessors(List<LogicalProcessors> logicalProcessors) {
	
		Assertions.assertNotNull(logicalProcessors);
		Assertions.assertFalse(logicalProcessors.isEmpty());
		LogicalProcessors logicalProcessor = logicalProcessors.get(0);
		Assertions.assertEquals(0, logicalProcessor.getNumaNode());
		Assertions.assertEquals(0, logicalProcessor.getPhysicalPackageNumber());
		Assertions.assertEquals(0, logicalProcessor.getPhysicalProcessorNumber());
		Assertions.assertEquals(0, logicalProcessor.getProcessorGroup());
		Assertions.assertEquals(0, logicalProcessor.getProcessorNumber());
	}
	
	private void validateProcessorIdentifier(ProcessorIdentifier processorIdentifier) {
		
		Assertions.assertNotNull(processorIdentifier);
		Assertions.assertEquals(3100000000L, processorIdentifier.getVendorFreq());
		Assertions.assertEquals(Boolean.TRUE, processorIdentifier.getCpu64bit());
		Assertions.assertEquals("6", processorIdentifier.getFamily());
		Assertions.assertEquals("Intel64 Family 6 Model 42 Stepping 7", processorIdentifier.getIdentifier());
		Assertions.assertEquals("Sandy Bridge (Client)", processorIdentifier.getMicroarchitecture());
		Assertions.assertEquals("42", processorIdentifier.getModel());
		Assertions.assertEquals("Intel(R) Core(TM) i5-2400 CPU @ 3.10GHz", processorIdentifier.getName());
		Assertions.assertEquals("R8C1FCAA002006C7", processorIdentifier.getProcessorID());
		Assertions.assertEquals("7", processorIdentifier.getStepping());
		Assertions.assertEquals("GenuineIntel", processorIdentifier.getVendor());
	}
	
	@Test
	public void deveLancarNotFoundExceptionQuandoIdNaoExistir() {
		
		assertThrows(NotFoundException.class, () -> {
			centralProcessorService.findById("123");
		});
	}
	
}
