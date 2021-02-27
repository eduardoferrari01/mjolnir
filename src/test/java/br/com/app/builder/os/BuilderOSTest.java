package br.com.app.builder.os;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.builder.os.InternetProtocolStatsBuilder;
import br.com.app.domain.builder.os.NetworkParamsBuilder;
import br.com.app.domain.builder.os.OSVersionInfoBuilder;
import br.com.app.domain.builder.os.OperatingSystemBuilder;
import br.com.app.domain.builder.os.ProcesseBuilder;
import br.com.app.domain.builder.os.ServiceBuilder;
import br.com.app.domain.builder.os.SessionsBuilder;
import br.com.app.domain.os.FileSystem;
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.domain.os.NetworkParams;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.domain.os.Processe;
import br.com.app.domain.os.Service;
import br.com.app.domain.os.Sessions;

public class BuilderOSTest {

	private final String path = "src/test/resources/";
	private static ColetaResultado coletaResultado;

	@BeforeAll
	public static void setup() {
		coletaResultado = new ColetaResultado();
		coletaResultado.setId("4aa6c0e7255c3b89987960d9097b40448079b48e0b51aa3160c486b2da7ff1cd");
	}

	@Test
	public void deveRetornarUmFileSystem() throws IOException {

		String json = Files.readString(Paths.get(path + "fileSystem.json")).trim();
		coletaResultado.setJson(json);
		FileSystem fileSystem = new FileSystemBuilder(coletaResultado).builder();

		Assertions.assertNotNull(fileSystem);
		Assertions.assertNotNull(fileSystem.getId());
		Assertions.assertFalse(fileSystem.getId().isEmpty());
		Assertions.assertFalse(fileSystem.getFileStores().isEmpty());

	}

	@Test
	public void deveRetornarUmInternetProtocolStats() throws IOException {

		String json = Files.readString(Paths.get(path + "internetProtocolStats.json")).trim();
		coletaResultado.setJson(json);
		InternetProtocolStats internetProtocolStats = new InternetProtocolStatsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(internetProtocolStats);
		Assertions.assertNotNull(internetProtocolStats.getId());
		Assertions.assertFalse(internetProtocolStats.getId().isEmpty());

	}

	@Test
	public void deveRetornarUmNetworkParams() throws IOException {

		String json = Files.readString(Paths.get(path + "networkParams.json")).trim();
		coletaResultado.setJson(json);
		NetworkParams networkParams = new NetworkParamsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(networkParams);
		Assertions.assertNotNull(networkParams.getId());
		Assertions.assertFalse(networkParams.getId().isEmpty());
		Assertions.assertFalse(networkParams.getDnsServers().isEmpty());

	}

	@Test
	public void deveRetornarUmOperatingSystem() throws IOException {

		String json = Files.readString(Paths.get(path + "operatingSystem.json")).trim();
		coletaResultado.setJson(json);
		OperatingSystem operatingSystem = new OperatingSystemBuilder(coletaResultado).builder();

		Assertions.assertNotNull(operatingSystem);
		Assertions.assertNotNull(operatingSystem.getId());
		Assertions.assertFalse(operatingSystem.getId().isEmpty());
	}

	@Test
	public void deveRetornarUmProcess() throws IOException {

		String json = Files.readString(Paths.get(path + "osProcess.json")).trim();
		coletaResultado.setJson(json);
		Processe processe = new ProcesseBuilder(coletaResultado).builder();

		Assertions.assertNotNull(processe);
		Assertions.assertNotNull(processe.getId());
		Assertions.assertFalse(processe.getId().isEmpty());
		Assertions.assertFalse(processe.getOsProcess().isEmpty());
	}

	@Test
	public void deveRetornarUmService() throws IOException {

		String json = Files.readString(Paths.get(path + "osService.json")).trim();
		coletaResultado.setJson(json);
		Service service = new ServiceBuilder(coletaResultado).builder();

		Assertions.assertNotNull(service);
		Assertions.assertNotNull(service.getId());
		Assertions.assertFalse(service.getId().isEmpty());
		Assertions.assertFalse(service.getOsService().isEmpty());
	}

	@Test
	public void deveRetornarUmSession() throws IOException {

		String json = Files.readString(Paths.get(path + "osSession.json")).trim();
		coletaResultado.setJson(json);
		Sessions sessions = new SessionsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(sessions);
		Assertions.assertNotNull(sessions.getId());
		Assertions.assertFalse(sessions.getId().isEmpty());
		Assertions.assertFalse(sessions.getOsSession().isEmpty());
	}

	@Test
	public void deveRetornarUmOSVersionInfo() throws IOException {

		String json = Files.readString(Paths.get(path + "osVersionInfo.json")).trim();
		coletaResultado.setJson(json);
		OSVersionInfo osVersionInfo = new OSVersionInfoBuilder(coletaResultado).builder();

		Assertions.assertNotNull(osVersionInfo);
		Assertions.assertNotNull(osVersionInfo.getId());
		Assertions.assertFalse(osVersionInfo.getId().isEmpty());

	}
}
