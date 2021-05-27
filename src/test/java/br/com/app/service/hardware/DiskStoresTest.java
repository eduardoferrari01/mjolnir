package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.DiskStoresBuilder;
import br.com.app.domain.builder.hardware.NetworkIFBuilder;
import br.com.app.domain.hardware.DiskStore;
import br.com.app.domain.hardware.Disks;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.domain.hardware.Partition;
import br.com.app.repository.hardware.DisksRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class DiskStoresTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks 
	private DisksService disksService;
	@Mock
	private DisksRepository disksRepository; 
	
	@BeforeAll
	public static void setup() {
		
		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadDisks()).builder();
	}
	
	@Test
	public void deveSalvarUmDisks() throws IOException {

		disksService.save(coletaResultado);
		verify(disksRepository).save(Mockito.any(Disks.class));
	}
	
	@Test
	public void  deveConstruirDisks() {

		Disks disks = new DiskStoresBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(disks);
		Assertions.assertEquals(coletaResultado.getId(), disks.getId());
		Assertions.assertNotNull(disks.getDiskStores());
		Assertions.assertFalse(disks.getDiskStores().isEmpty());
		validateDiskStore(disks.getDiskStores().get(0));
	}
	
	private void validateDiskStore(DiskStore diskStore) {
		
		Assertions.assertEquals(0 ,diskStore.getCurrentQueueLength());
		Assertions.assertEquals(3240115712L ,diskStore.getReadBytes());
		Assertions.assertEquals(114154 ,diskStore.getReads());
		Assertions.assertEquals(240057409536L ,diskStore.getSize());
		Assertions.assertEquals(1612633018065L ,diskStore.getTimeStamp());
		Assertions.assertEquals(1246057L, diskStore.getTransferTime());
		Assertions.assertEquals(12808667648L ,diskStore.getWriteBytes());
		Assertions.assertEquals(810385L ,diskStore.getWrites());
		Assertions.assertEquals("KINGSTON_SUV411S37240X" ,diskStore.getModel());
		Assertions.assertEquals("/dev/sda" ,diskStore.getName());
		Assertions.assertEquals("51927W1254022C4C" ,diskStore.getSerial());
		Assertions.assertNotNull(diskStore.getPartitions());
		Assertions.assertFalse(diskStore.getPartitions().isEmpty());
		
		Partition partition = diskStore.getPartitions().get(0);
		validatePartition(partition);
	}
	
	private void validatePartition(Partition partition) {
		
		Assertions.assertEquals(8 ,partition.getMajor());
		Assertions.assertEquals(1 ,partition.getMinor());
		Assertions.assertEquals(92624209920L ,partition.getSize());
		Assertions.assertEquals("/dev/sda1" ,partition.getIdentification());
		Assertions.assertEquals("/mnt" ,partition.getMountPoint());
		Assertions.assertEquals("/sys/devices/pci0000:00/0000:00:1f.2/ata5/host4/target4:0:0/4:0:0:0/block/sda/sda1" ,partition.getName());
		Assertions.assertEquals("ext4" ,partition.getType());
		Assertions.assertEquals("edb4414c-8423-41b1-9ed4-w9dc748d29e1" ,partition.getUuid());
	}
	
	@Test
	public void deveRetornarDiskStoreVazio() {

		Disks disks = new DiskStoresBuilder(coletaResultado).builder();
		disks.setDiskStores(null);
		Assertions.assertTrue(disks.getDiskStores().isEmpty());
	}
	
}
