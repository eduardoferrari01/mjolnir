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

import br.com.app.controller.hardware.GraphicsCardsController;
import br.com.app.domain.ColetaResultado;
import br.com.app.service.hardware.GraphicsCardsService;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@WebMvcTest(GraphicsCardsController.class)
public class GraphicsCardsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean 
	private GraphicsCardsService graphicsCardsService;
	private static String json = "";
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		json = loadJson.loadGraphicsCards();
	}
	
	@Test
	public void deveSalvarGraphicsCards() throws Exception {
		
		String coletaResultadoJson = new ColetaResultadoTestDataBuilder().setJson(json).builderForJson();
		
		mockMvc.perform(post("/api/graphicscards")
		           .contentType(MediaType.APPLICATION_JSON)
		           .content(coletaResultadoJson) 
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		
		verify(graphicsCardsService).save(Mockito.any(ColetaResultado.class));
	}
}
