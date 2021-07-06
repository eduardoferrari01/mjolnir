package br.com.app.controll.hardware;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.app.controller.hardware.HardwareInformationController;
import br.com.app.dto.HardwareInformation;
import br.com.app.service.hardware.HardwareInformationService;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;
import br.com.app.util.DomainBuilder;
import br.com.app.util.ObjectMapperCustomized;

@WebMvcTest(HardwareInformationController.class)
public class HardwareInformationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean 
	private HardwareInformationService hardwareInformationService;
	private static String json = "";
	private static ObjectMapper objectMapper;
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		json = loadJson.loadHardwareInformation();
		objectMapper = new ObjectMapperCustomized().create();
	}
	
	@Test
	public void deveRetornarHardwareInformation() throws Exception  {
		
		String ID = "1111";
		
		HardwareInformation hardwareInformation = new DomainBuilder().builder(json, HardwareInformation.class);
		
		when(hardwareInformationService.findById(ID)).thenReturn(hardwareInformation);
 	
		 MvcResult mvcResult = mockMvc.perform(get("/api/hardwareinformation/"+ID)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	 
		String jsonResturn = mvcResult.getResponse().getContentAsString();
		
		Assertions.assertEquals(objectMapper.readTree(json), objectMapper.readTree(jsonResturn));
		
		verify(hardwareInformationService).findById(ID);
	}
}
