package br.com.app.util.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.domain.hardware.DiskStore;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;
import br.com.app.util.DomainBuilder;

public class DomainBuilderTest {

	private static LoadFileHardwareJson loadJson;
	
	@BeforeAll
	public static void setup() {
		
		loadJson = new LoadFileHardwareJson();
	}
	
	@Test
	public void quandoJsonNaoEValidoDeveRetornarNull() {
		
		Assertions.assertNull(new DomainBuilder().builder("", ComputerSystem.class));
	}
	
	@Test
	public void quandoJsonEValidoDeveRetornarUmObjeto() {
		
		ComputerSystem computerSystem  = new DomainBuilder().builder(loadJson.loadComputerSystem(), ComputerSystem.class);
		Assertions.assertNotNull(computerSystem);
	}
	
	@Test
	public void quandoJsonNaoEValidoDeveRetornarUmaListaVazia() {
		
		Assertions.assertTrue(new DomainBuilder().collectionBuilder("", DiskStore.class).isEmpty());
	}
	
	@Test
	public void quandoJsonEValidoDeveRetornarUmaLista() {
		
		List<DiskStore> lista = new DomainBuilder().collectionBuilder(loadJson.loadDisks(), DiskStore.class);
		Assertions.assertFalse(lista.isEmpty());
	}
	
}
