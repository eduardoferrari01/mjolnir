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
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.os.FileSystem;
import br.com.app.domain.os.OSFileStore;
import br.com.app.repository.os.FileSystemRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

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
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadFileSystem()).builder();
	}
	
	@Test
	public void deveSalvarUmFileSystem() {
		
		fileSystemService.save(coletaResultado);
	    verify(fileSystemRepository).save(Mockito.any(FileSystem.class));
	}
	
	@Test
	public void deveConstruirFileSystem() {
		
		FileSystem fileSystem = new FileSystemBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(fileSystem);
		Assertions.assertEquals(coletaResultado.getId(), fileSystem.getId());
		Assertions.assertEquals(8223372011888875817L, fileSystem.getMaxFileDescriptors());
		Assertions.assertEquals(22328, fileSystem.getOpenFileDescriptors());
		Assertions.assertNotNull(fileSystem.getFileStores());
		Assertions.assertFalse(fileSystem.getFileStores().isEmpty());
		
		OSFileStore osFileStore = fileSystem.getFileStores().get(0);
		
		Assertions.assertEquals("Local Disk", osFileStore.getDescription());
		Assertions.assertEquals(1563356, osFileStore.getFreeInodes());
		Assertions.assertEquals("8723048168", osFileStore.getFreeSpace());
		Assertions.assertEquals("xxx", osFileStore.getLabel());
		Assertions.assertEquals("", osFileStore.getLogicalVolume());
		Assertions.assertEquals("/mnt", osFileStore.getMount());
		Assertions.assertEquals("bbbb", osFileStore.getName());
		Assertions.assertEquals("rw,noatime,discard", osFileStore.getOptions());
		Assertions.assertEquals(6660672, osFileStore.getTotalInodes());
		Assertions.assertEquals(90014981299L, osFileStore.getTotalSpace());
		Assertions.assertEquals("ext4", osFileStore.getType());
		Assertions.assertEquals(4028063699L, osFileStore.getUsableSpace());
		Assertions.assertEquals("edc3314c-1403-45w1-9et4-c9ao746d29e1", osFileStore.getUuid());
		Assertions.assertEquals("/dev/sda1", osFileStore.getVolume());
	}
}