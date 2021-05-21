package br.com.app.builder.os;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.builder.os.ProcesseBuilder;
import br.com.app.domain.builder.os.ServiceOSBuilder;
import br.com.app.domain.builder.os.SessionsBuilder;
import br.com.app.domain.os.FileSystem;
import br.com.app.domain.os.Processe;
import br.com.app.domain.os.ServiceOS;
import br.com.app.domain.os.Sessions;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

public class BuilderOSTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	
	
	@BeforeAll
	public static void setup() {
		coletaResultado = new ColetaResultadoTestDataBuilder().builder();
		loadFileOSJson = new LoadFileOSJson();
		
	}

	@Test
	public void deveRetornarUmFileSystem() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadFileSystem());
		FileSystem fileSystem = new FileSystemBuilder(coletaResultado).builder();

		Assertions.assertNotNull(fileSystem);
		Assertions.assertNotNull(fileSystem.getId());
		Assertions.assertFalse(fileSystem.getId().isEmpty());
		Assertions.assertFalse(fileSystem.getFileStores().isEmpty());

	}
	
	@Test
	public void deveRetornarUmService() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadOSService());
		ServiceOS service = new ServiceOSBuilder(coletaResultado).builder();

		Assertions.assertNotNull(service);
		Assertions.assertNotNull(service.getId());
		Assertions.assertFalse(service.getId().isEmpty());
		Assertions.assertFalse(service.getOsService().isEmpty());
	}

	@Test
	public void deveRetornarUmSession() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadOSSession());
		Sessions sessions = new SessionsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(sessions);
		Assertions.assertNotNull(sessions.getId());
		Assertions.assertFalse(sessions.getId().isEmpty());
		Assertions.assertFalse(sessions.getOsSession().isEmpty());
	}

	
}
