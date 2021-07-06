package br.com.app.controll.os;

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

import br.com.app.controller.os.OperatingSystemInformationController;
import br.com.app.dto.os.OperatingSystemInformation;
import br.com.app.service.os.OperatingSystemInformationService;
import br.com.app.test.data.loadfile.LoadFileOSJson;
import br.com.app.util.DomainBuilder;
import br.com.app.util.ObjectMapperCustomized;

@WebMvcTest(OperatingSystemInformationController.class)
public class OperatingSystemInformationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OperatingSystemInformationService osInformationService;
	private static ObjectMapper objectMapper;
	private static String json = "";
	
	@BeforeAll
	public static void setup() {
		
		LoadFileOSJson loadJson = new LoadFileOSJson();
		json =  loadJson.loadOsInformation();
		objectMapper = new ObjectMapperCustomized().create();
	}

	@Test
	public void deveRetornarOperatingSystemInformation() throws Exception {
		
		String ID = "123456";
		
		OperatingSystemInformation operatingSystemInformation = new DomainBuilder().builder(json, OperatingSystemInformation.class);
		
		when(osInformationService.findById(ID)).thenReturn(operatingSystemInformation);
 	
		 MvcResult mvcResult = mockMvc.perform(get("/api/operatingsysteminformation/"+ID)
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	 
		String jsonResturn = mvcResult.getResponse().getContentAsString();
		
		Assertions.assertEquals(objectMapper.readTree(json), objectMapper.readTree(jsonResturn));
		
		verify(osInformationService).findById(ID);
 
	}
}
