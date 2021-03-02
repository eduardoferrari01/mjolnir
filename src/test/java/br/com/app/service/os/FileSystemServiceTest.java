package br.com.app.service.os;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.FileSystem;
import br.com.app.repository.os.FileSystemRepository;
import br.com.app.util.ColetaResultadoTestBuilder;
import br.com.app.util.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class FileSystemServiceTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks
	private FileSystemService fileSystemService;
	@Mock
	private FileSystemRepository fileSystemRepository;
	 
	@BeforeAll
	public static void setup() {
		
		LoadFileOSJson loadJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestBuilder().setJson(loadJson.loadFileSystem()).builder();
	}
	
	@Test
	public void deveSalvarUmFileSystem() {
		
		fileSystemService.save(coletaResultado);
	    verify(fileSystemRepository).save(Mockito.any(FileSystem.class));
	}
}
