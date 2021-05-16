package br.com.app.builder.os;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.builder.os.InternetProtocolStatsBuilder;
import br.com.app.domain.builder.os.NetworkParamsBuilder;
import br.com.app.domain.builder.os.ProcesseBuilder;
import br.com.app.domain.builder.os.ServiceOSBuilder;
import br.com.app.domain.builder.os.SessionsBuilder;
import br.com.app.domain.os.FileSystem;
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.domain.os.NetworkParams;
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
	public void deveRetornarUmInternetProtocolStats() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadInternetProtocolStats());
		InternetProtocolStats internetProtocolStats = new InternetProtocolStatsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(internetProtocolStats);
		Assertions.assertNotNull(internetProtocolStats.getId());
		Assertions.assertFalse(internetProtocolStats.getId().isEmpty());

	}

	@Test
	public void deveRetornarUmNetworkParams() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadNetworkParams());
		NetworkParams networkParams = new NetworkParamsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(networkParams);
		Assertions.assertNotNull(networkParams.getId());
		Assertions.assertFalse(networkParams.getId().isEmpty());
		Assertions.assertFalse(networkParams.getDnsServers().isEmpty());

	}
	
	@Test
	public void deveRetornarUmProcess() throws IOException {

		coletaResultado.setJson(loadFileOSJson.loadOSProcess());
		Processe processe = new ProcesseBuilder(coletaResultado).builder();

		Assertions.assertNotNull(processe);
		Assertions.assertNotNull(processe.getId());
		Assertions.assertFalse(processe.getId().isEmpty());
		Assertions.assertFalse(processe.getOsProcess().isEmpty());
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
