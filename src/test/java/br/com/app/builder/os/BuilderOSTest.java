
package br.com.app.builder.os;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.os.FileSystem;
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
}
