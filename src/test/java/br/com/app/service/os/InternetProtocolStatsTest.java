package br.com.app.service.os;

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
import br.com.app.domain.builder.os.InternetProtocolStatsBuilder;
import br.com.app.domain.os.InternetProtocolStats;
import br.com.app.domain.os.TcpStats;
import br.com.app.domain.os.UdpStats;
import br.com.app.repository.os.InternetProtocolStatsRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class InternetProtocolStatsTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private InternetProtocolStatsService internetProtocolStatsService;
	@Mock
	private InternetProtocolStatsRepository internetProtocolStatsRepository;
	 
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadInternetProtocolStats())
				.builder();
	}

	@Test
	public void deveSalvarUmInternetProtocolStats() throws IOException {

		internetProtocolStatsService.save(coletaResultado);
		verify(internetProtocolStatsRepository).save(Mockito.any(InternetProtocolStats.class));
	}
	
	@Test
	public void deveConstruirInternetProtocolStats() {

		InternetProtocolStats internetProtocolStats = new InternetProtocolStatsBuilder(coletaResultado).builder();

		Assertions.assertNotNull(internetProtocolStats);
		Assertions.assertEquals(coletaResultado.getId(), internetProtocolStats.getId());
		
		Assertions.assertNotNull(internetProtocolStats.getTcpv4Stats());
		validateTcpStats(internetProtocolStats.getTcpv4Stats());
		Assertions.assertNotNull(internetProtocolStats.getTcpv6Stats());
		validateTcpStats(internetProtocolStats.getTcpv6Stats());
		
		Assertions.assertNotNull(internetProtocolStats.getUdpv4Stats());
		validateUdpStats(internetProtocolStats.getUdpv4Stats());
		Assertions.assertNotNull(internetProtocolStats.getUdpv6Stats());
		validateUdpStats(internetProtocolStats.getUdpv6Stats());
	
	}
	
	private void validateTcpStats(TcpStats tcpStats) {
		
		Assertions.assertEquals(0, tcpStats.getConnectionFailures());
		Assertions.assertEquals(0, tcpStats.getConnectionsActive());
		Assertions.assertEquals(0, tcpStats.getConnectionsEstablished());
		Assertions.assertEquals(0, tcpStats.getConnectionsPassive());
		Assertions.assertEquals(0, tcpStats.getConnectionsReset());
		
		Assertions.assertEquals(0, tcpStats.getInErrors());
		Assertions.assertEquals(0, tcpStats.getOutResets());
		Assertions.assertEquals(0, tcpStats.getSegmentsReceived());
		Assertions.assertEquals(0, tcpStats.getSegmentsRetransmitted());
		Assertions.assertEquals(0, tcpStats.getSegmentsSent());
	}
	
	private void validateUdpStats(UdpStats udpStats) {
		
		Assertions.assertEquals(0, udpStats.getDatagramsNoPort());
		Assertions.assertEquals(0, udpStats.getDatagramsReceived());
		Assertions.assertEquals(0, udpStats.getDatagramsReceivedErrors());
		Assertions.assertEquals(0, udpStats.getDatagramsSent());
	}
}
