package br.com.app.test.builder;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class ColetaResultadoTestDataBuilderTest {

	private static String JSON = "";
	private static String ID_Default = "4aa6c0e7255c3b89987960d9097b40448079b48e0b51aa3160c486b2da7ff1cd";
	@Mock
	private ColetaResultadoTestDataBuilder testDataBuilder;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		JSON = loadJson.loadProcessor(); 
	}
	
	@Test
	public void deveConstruirColetaResultadoComIdPadrao(){
		
		ColetaResultado coletaResultado = new ColetaResultadoTestDataBuilder().setJson(JSON).builder();
		
		Assertions.assertNotNull(coletaResultado);
		Assertions.assertEquals(ID_Default, coletaResultado.getId());
		Assertions.assertEquals(JSON, coletaResultado.getJson());
	}
	
	@Test
	public void deveConstruirColetaResultadoComIdPersonalizado(){
		
		String ID_CUSTOM = "xxxxAAAABCCC";
		
		ColetaResultado coletaResultado = new ColetaResultadoTestDataBuilder().setId(ID_CUSTOM).setJson(JSON).builder();
		Assertions.assertNotNull(coletaResultado);
		Assertions.assertEquals(ID_CUSTOM, coletaResultado.getId());
		Assertions.assertEquals(JSON, coletaResultado.getJson());
	}
	
	@Test
	public void deveConstruirColetaResultadoComString(){
		
		String coletaResultado = new ColetaResultadoTestDataBuilder().setJson(JSON).builderForJson();
		Assertions.assertNotNull(coletaResultado);
		Assertions.assertFalse(coletaResultado.isEmpty());
	}
	
}