package br.com.app.service.hardware;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.hardware.NetworkIFBuilder;
import br.com.app.domain.enums.IfOperStatus;
import br.com.app.domain.hardware.Network;
import br.com.app.domain.hardware.NetworkIF;
import br.com.app.repository.hardware.NetworkIFRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileHardwareJson;

@ExtendWith(MockitoExtension.class)
public class NetworkIFsTest {

	private static ColetaResultado coletaResultado;
	@InjectMocks
	private NetworkIFService networkIFService;
	@Mock
	private NetworkIFRepository networkIFRepository;

	@BeforeAll
	public static void setup() {

		LoadFileHardwareJson loadJson = new LoadFileHardwareJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadJson.loadNetworkIF()).builder();
	}

	@Test
	public void deveSalvarUmNetworkIFs() throws IOException {

		networkIFService.save(coletaResultado);
		verify(networkIFRepository).save(Mockito.any(NetworkIF.class));
	}

	@Test
	public void deveConstruirNetworkIFs() {

		NetworkIF networkIF = new NetworkIFBuilder(coletaResultado).builder();
		Assertions.assertNotNull(networkIF);
		Assertions.assertEquals(coletaResultado.getId(), networkIF.getId());
		Assertions.assertNotNull(networkIF.getNetworks());
		Assertions.assertFalse(networkIF.getNetworks().isEmpty());

		validateNetwork(networkIF.getNetworks().get(0));
	}

	private void validateNetwork(Network network) {

		Assertions.assertNotNull(network);
		Assertions.assertEquals(117392993L, network.getBytesRecv());
		Assertions.assertEquals(920417460L, network.getBytesSent());
		Assertions.assertEquals(0, network.getCollisions());
		Assertions.assertEquals(Boolean.TRUE, network.getConnectorPresent());
		Assertions.assertEquals("veth75b58e8", network.getDisplayName());
		Assertions.assertEquals("", network.getIfAlias());
		Assertions.assertEquals(IfOperStatus.TESTING, network.getIfOperStatus());
		Assertions.assertEquals(1559569, network.getPacketsSent());
		Assertions.assertEquals(1, network.getIfType());
		Assertions.assertEquals(0, network.getInDrops());
		Assertions.assertEquals(0, network.getInErrors());
		Assertions.assertEquals(Boolean.FALSE, network.getKnownVmMacAddr());
		Assertions.assertEquals("fr:01:3w:ce:51:b0", network.getMacaddr());
		Assertions.assertEquals(1500, network.getMtu());
		Assertions.assertEquals("veth75b58e8", network.getName());
		Assertions.assertEquals(0, network.getNdisPhysicalMediumType());
		Assertions.assertEquals(0, network.getOutErrors());
		Assertions.assertEquals(1008822, network.getPacketsRecv());
		Assertions.assertEquals(10485760000L, network.getSpeed());
		Assertions.assertEquals(1612641348584L, network.getTimeStamp());
		Assertions.assertFalse(network.getIpv4addr().isEmpty());
		Assertions.assertEquals(Arrays.asList("abc", "123", "cbc"), network.getIpv4addr());
		Assertions.assertFalse(network.getSubnetMasks().isEmpty());
		Assertions.assertEquals(Arrays.asList("123", "543", "987"), network.getSubnetMasks());
		Assertions.assertFalse(network.getIpv6addr().isEmpty());
		Assertions.assertEquals(Arrays.asList("fe78:0:0:0:1207:w153:398f:12aa", "fe78:0:0:0:cc02:3eff:fece:42c0"), network.getIpv6addr());
		Assertions.assertFalse(network.getPrefixLengths().isEmpty());
		
		short prefixLengths1 = network.getPrefixLengths().get(0);
		short prefixLengths2 = network.getPrefixLengths().get(1);
		
		Assertions.assertEquals(64, prefixLengths1);
		Assertions.assertEquals(64, prefixLengths2);
	}
	
	@Test
	public void deveRetornarNetworksVazio() {

		NetworkIF networkIF = new NetworkIFBuilder(coletaResultado).builder();
		networkIF.setNetworks(null);
		Assertions.assertTrue(networkIF.getNetworks().isEmpty());
	}
}