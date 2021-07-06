package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.GraphicsCardsBuilder;
import br.com.app.domain.hardware.GraphicsCard;
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.repository.hardware.GraphicsCardsRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class GraphicsCardsTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private GraphicsCardsService graphicsCardsService;
	@Mock
	private GraphicsCardsRepository graphicsCardsRepository;  
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadGraphicsCards()).builder();
	}
	
	@Test
	public void deveSalvarUmGraphicsCards() throws IOException {

		graphicsCardsService.save(coletaResultado);
		verify(graphicsCardsRepository).save(Mockito.any(GraphicsCards.class));
	}
	
	@Test
	public void deveConstruirGraphicsCards(){
		
		GraphicsCards graphicsCard = new GraphicsCardsBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(graphicsCard);
		Assertions.assertEquals(coletaResultado.getId(), graphicsCard.getId());
		Assertions.assertFalse(graphicsCard.getGraphicsCards().isEmpty());
		
		List<GraphicsCard> graphicsCards = graphicsCard.getGraphicsCards();
		
		Assertions.assertNotNull(graphicsCards);
		
		GraphicsCard graphicsCardActual = graphicsCards.get(0);
		
		Assertions.assertEquals("0x0115", graphicsCardActual.getDeviceId());
		Assertions.assertEquals("2nd Generation Core Processor Family Integrated Graphics Controller", graphicsCardActual.getName());
		Assertions.assertEquals("Intel Corporation (0x8086)", graphicsCardActual.getVendor());
		Assertions.assertEquals("unknown" ,graphicsCardActual.getVersionInfo());
		Assertions.assertEquals(268435456L, graphicsCardActual.getVram());
	}
}