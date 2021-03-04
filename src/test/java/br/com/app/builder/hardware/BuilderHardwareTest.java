package br.com.app.builder.hardware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.builder.hardware.ComputerSystemBuilder;
import br.com.app.domain.builder.hardware.DiskStoresBuilder;
import br.com.app.domain.builder.hardware.DisplaysBuilder;
import br.com.app.domain.builder.hardware.GraphicsCardsBuilder;
import br.com.app.domain.builder.hardware.MemoryBuilder;
import br.com.app.domain.builder.hardware.NetworkIFBuilder;
import br.com.app.domain.builder.hardware.PowerSourcesBuilder;
import br.com.app.domain.builder.hardware.SensorBuilder;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.Disks;
import br.com.app.domain.hardware.Displays;
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.domain.hardware.Memory;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.domain.hardware.PowerSources;
import br.com.app.domain.hardware.Sensor;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

public class BuilderHardwareTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileHardwareJson loadFileHardwareJson;
	
	@BeforeAll
	public static void setup() {

		coletaResultado = new ColetaResultadoTestDataBuilder().builder();
		loadFileHardwareJson = new LoadFileHardwareJson();
	}
	
	@Test
	public void deveRetornaUmComputerSystem() {

		coletaResultado.setJson(loadFileHardwareJson.loadComputerSystem());
		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(computerSystem);
		Assertions.assertNotNull(computerSystem.getId());
		Assertions.assertFalse(computerSystem.getId().isEmpty());
	}
	
	@Test
	public void deveRetornaUmDisks() {

		coletaResultado.setJson(loadFileHardwareJson.loadDisks());
		Disks disks = new DiskStoresBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(disks);
		Assertions.assertNotNull(disks.getId());
		Assertions.assertFalse(disks.getId().isEmpty());
		Assertions.assertFalse(disks.getDiskStores().isEmpty());
	}
	
	@Test
	public void deveRetornaUmDisplays() {
		
	    coletaResultado.setJson(loadFileHardwareJson.loadDisplays());
		Displays displays = new DisplaysBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(displays);
		Assertions.assertNotNull(displays.getId());
		Assertions.assertFalse(displays.getId().isEmpty());
		Assertions.assertFalse(displays.getDisplays().isEmpty());
		
	}
	
	@Test
	public void deveRetornarUmGraphicsCards(){
	
		coletaResultado.setJson(loadFileHardwareJson.loadGraphicsCards());
		GraphicsCards graphicsCards = new GraphicsCardsBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(graphicsCards);
		Assertions.assertNotNull(graphicsCards.getId());
		Assertions.assertFalse(graphicsCards.getId().isEmpty());
		Assertions.assertFalse(graphicsCards.getGraphicsCards().isEmpty());
	}
	
	@Test
	public void deveRetornarUmMemory(){
		
		coletaResultado.setJson(loadFileHardwareJson.loadMemory());
		Memory memory = new MemoryBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(memory);
		Assertions.assertNotNull(memory.getId());
		Assertions.assertFalse(memory.getId().isEmpty());
	 	
	}
	
	@Test
	public void deveRetornarUmNetworkIF(){
	
		coletaResultado.setJson(loadFileHardwareJson.loadNetworkIF());
		NetworkIF networkIF = new NetworkIFBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(networkIF);
		Assertions.assertNotNull(networkIF.getId());
		Assertions.assertFalse(networkIF.getId().isEmpty());
		Assertions.assertFalse(networkIF.getNetworks().isEmpty());
	}
	
	@Test
	public void deveRetornarUmPowerSources(){
	
		coletaResultado.setJson(loadFileHardwareJson.loadPowerSources());
		PowerSources powerSources = new PowerSourcesBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(powerSources);
		Assertions.assertNotNull(powerSources.getId());
		Assertions.assertFalse(powerSources.getId().isEmpty());
		Assertions.assertFalse(powerSources.getPowerSources().isEmpty());
	}
	
	@Test
	public void deveRetornarUmCentralProcessor(){
		
		coletaResultado.setJson(loadFileHardwareJson.loadProcessor());
		CentralProcessor processor = new CentralProcessorBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(processor);
		Assertions.assertNotNull(processor.getId());
		Assertions.assertFalse(processor.getId().isEmpty());
	 	
	}
	
	@Test
	public void deveRetornarUmSensor(){
		
		coletaResultado.setJson(loadFileHardwareJson.loadSensor());
		Sensor sensor = new SensorBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(sensor);
		Assertions.assertNotNull(sensor.getId());
		Assertions.assertFalse(sensor.getId().isEmpty());
	}
	
}
