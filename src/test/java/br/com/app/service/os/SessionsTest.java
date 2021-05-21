package br.com.app.service.os;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.SessionsBuilder;
import br.com.app.domain.os.OSSession;
import br.com.app.domain.os.Sessions;
import br.com.app.repository.os.SessionsRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class SessionsTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private SessionsService sessionsService;
	@Mock
	private SessionsRepository sessionsRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOSSession())
				.builder();
	}
	
	@Test
	public void deveSalvarUmSessions() {

		sessionsService.save(coletaResultado);
		verify(sessionsRepository).save(Mockito.any(Sessions.class));
	}
	
	@Test
	public void deveConstruirSessions() {
	
		Sessions sessions = new SessionsBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(sessions);
		Assertions.assertEquals(coletaResultado.getId(), sessions.getId());
		Assertions.assertNotNull(sessions.getOsSession());
		Assertions.assertFalse(sessions.getOsSession().isEmpty());
		
		OSSession osSession = sessions.getOsSession().get(0);
		 
		Assertions.assertNotNull(osSession);
		Assertions.assertEquals("www", osSession.getHost());  
		Assertions.assertEquals(1614434870016L, osSession.getLoginTime());  
		Assertions.assertEquals("tty1", osSession.getTerminalDevice());  
		Assertions.assertEquals("jose", osSession.getUserName());  
	}
	
}
