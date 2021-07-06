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

import br.com.app.controller.hardware.MemoryController;
import br.com.app.domain.ColetaResultado;
import br.com.app.service.hardware.MemoryService;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@WebMvcTest(MemoryController.class)
public class MemoryControllerTest {

	@Autowired
	private MockMvc mockMvc;	
	@MockBean
	private MemoryService memoryService;

	private static String json = "";
 	
	@BeforeAll
	public static void setup() {

		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		json = loadJson.loadMemory();
	}

	@Test
	public void deveSalvarMemory() throws Exception {
		
		String coletaResultadoJson = new ColetaResultadoTestDataBuilder().setJson(json).builderForJson();
		
		mockMvc.perform(post("/api/memory/").contentType(MediaType.APPLICATION_JSON).content(coletaResultadoJson)
 				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		 
		verify(memoryService).save(Mockito.any(ColetaResultado.class));
	}

}
