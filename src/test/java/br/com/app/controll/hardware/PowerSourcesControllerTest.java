package br.com.app.controll.hardware;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.app.controller.hardware.PowerSourcesController;
import br.com.app.domain.ColetaResultado;
import br.com.app.service.hardware.PowerSourcesService;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@WebMvcTest(PowerSourcesController.class)
public class PowerSourcesControllerTest {

	@Autowired
	private MockMvc mockMvc;	
	@MockBean
	private PowerSourcesService powerSourcesService;
	private static String json = "";
	
	@BeforeAll
	public static void setup() {

		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		json = loadJson.loadPowerSources();
	}

	@Test
	public void deveSalvarPowerSources() throws Exception {
		
		String coletaResultadoJson = new ColetaResultadoTestDataBuilder().setJson(json).builderForJson();
	    
		mockMvc.perform(post("/api/powersources").contentType(MediaType.APPLICATION_JSON).content(coletaResultadoJson)
 				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		 
		verify(powerSourcesService).save(Mockito.any(ColetaResultado.class));
	}
	
}
