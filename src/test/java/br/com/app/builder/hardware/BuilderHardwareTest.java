package br.com.app.builder.hardware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.ComputerSystemBuilder;
import br.com.app.domain.builder.hardware.DiskStoresBuilder;
import br.com.app.domain.builder.hardware.DisplaysBuilder;
import br.com.app.domain.builder.hardware.GraphicsCardsBuilder;
import br.com.app.domain.builder.hardware.MemoryBuilder;
import br.com.app.domain.builder.hardware.NetworkIFBuilder;
import br.com.app.domain.builder.hardware.PowerSourcesBuilder;
import br.com.app.domain.builder.hardware.CentralProcessorBuilder;
import br.com.app.domain.builder.hardware.SensorBuilder;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.Disks;
import br.com.app.domain.hardware.Displays;
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.domain.hardware.Memory;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.domain.hardware.PowerSources;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.domain.hardware.Sensor;

public class BuilderHardwareTest {

	private final String path = "src/test/resources/";
	private static ColetaResultado coletaResultado;
	
	@BeforeAll
	public static void setup() {
		coletaResultado = new ColetaResultado();
		coletaResultado.setId("4aa6c0e7255c3b89987960d9097b40448079b48e0b51aa3160c486b2da7ff1cd");
	}
	
	@Test
	public void deveRetornaUmComputerSystem() throws IOException {

		String json = Files.readString(Paths.get(path+"computerSystem.json")).trim();
		coletaResultado.setJson(json);
		ComputerSystem computerSystem = new ComputerSystemBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(computerSystem);
		Assertions.assertNotNull(computerSystem.getId());
		Assertions.assertFalse(computerSystem.getId().isEmpty());
	}
	
	@Test
	public void deveRetornaUmDisks() throws IOException {

		String json = Files.readString(Paths.get(path+"disks.json")).trim();
		coletaResultado.setJson(json);
		Disks disks = new DiskStoresBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(disks);
		Assertions.assertNotNull(disks.getId());
		Assertions.assertFalse(disks.getId().isEmpty());
		Assertions.assertFalse(disks.getDiskStores().isEmpty());
	}
	
	@Test
	public void deveRetornaUmDisplays() throws IOException {
		
		String json = Files.readString(Paths.get(path+"displays.json")).trim();
		coletaResultado.setJson(json);
		Displays displays = new DisplaysBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(displays);
		Assertions.assertNotNull(displays.getId());
		Assertions.assertFalse(displays.getId().isEmpty());
		Assertions.assertFalse(displays.getDisplays().isEmpty());
		
	}
	
	@Test
	public void deveRetornarUmGraphicsCards()  throws IOException{
	
		String json = Files.readString(Paths.get(path+"graphicsCards.json")).trim();
		coletaResultado.setJson(json);
		GraphicsCards graphicsCards = new GraphicsCardsBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(graphicsCards);
		Assertions.assertNotNull(graphicsCards.getId());
		Assertions.assertFalse(graphicsCards.getId().isEmpty());
		Assertions.assertFalse(graphicsCards.getGraphicsCards().isEmpty());
	}
	
	@Test
	public void deveRetornarUmMemory() throws IOException{
		
		String json = Files.readString(Paths.get(path+"memory.json")).trim();
		coletaResultado.setJson(json);
		Memory memory = new MemoryBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(memory);
		Assertions.assertNotNull(memory.getId());
		Assertions.assertFalse(memory.getId().isEmpty());
	 	
	}
	
	@Test
	public void deveRetornarUmNetworkIF()  throws IOException{
	
		String json = Files.readString(Paths.get(path+"networkIF.json")).trim();
		coletaResultado.setJson(json);
		NetworkIF networkIF = new NetworkIFBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(networkIF);
		Assertions.assertNotNull(networkIF.getId());
		Assertions.assertFalse(networkIF.getId().isEmpty());
		Assertions.assertFalse(networkIF.getNetworks().isEmpty());
	}
	
	@Test
	public void deveRetornarUmPowerSources()  throws IOException{
	
		String json = Files.readString(Paths.get(path+"powerSources.json")).trim();
		coletaResultado.setJson(json);
		PowerSources powerSources = new PowerSourcesBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(powerSources);
		Assertions.assertNotNull(powerSources.getId());
		Assertions.assertFalse(powerSources.getId().isEmpty());
		Assertions.assertFalse(powerSources.getPowerSources().isEmpty());
	}
	
	@Test
	public void deveRetornarUmCentralProcessor() throws IOException{
		
		String json = Files.readString(Paths.get(path+"processor.json")).trim();
		coletaResultado.setJson(json);
		CentralProcessor processor = new CentralProcessorBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(processor);
		Assertions.assertNotNull(processor.getId());
		Assertions.assertFalse(processor.getId().isEmpty());
	 	
	}
	
	@Test
	public void deveRetornarUmSensor() throws IOException{
		
		String json = Files.readString(Paths.get(path+"sensor.json")).trim();
		coletaResultado.setJson(json);
		Sensor sensor = new SensorBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(sensor);
		Assertions.assertNotNull(sensor.getId());
		Assertions.assertFalse(sensor.getId().isEmpty());
	}
	
}
