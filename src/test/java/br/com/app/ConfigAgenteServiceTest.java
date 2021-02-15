package br.com.app;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.ConfigAgente;
import br.com.app.repository.config.ConfigAgenteRepository;
import br.com.app.service.config.ConfigAgenteService;

@ExtendWith(MockitoExtension.class)
public class ConfigAgenteServiceTest {

	@Mock
	private ConfigAgenteRepository configAgenteRepository;

	@InjectMocks
	private ConfigAgenteService configAgenteService;

	private final String hostName = "meupc";
	private final String hash = "d60079488fed3bbfd189ee5df6bdc000a5e1347296682b15f5e50fdd59112e70";

	@Test
	public void deveCriarUmNovoConfigAgenteQuandoHostNameNaoExisti() {

		ConfigAgente configAgente = configAgenteService.createConfig(hostName);

		Assertions.assertNotNull(configAgente);
		Assertions.assertEquals(hash, configAgente.getHash());
		Assertions.assertEquals(3L, configAgente.getTempoEspera());
		Assertions.assertEquals(hostName, configAgente.getHostName());
		verify(configAgenteRepository).save(configAgente);
	}

	@Test
	public void deveRetornarUmConfigAgenteQuandoHostNameExisti() {

		ConfigAgente configAgente = new ConfigAgente.Builder(this.hostName).build();

		when(configAgenteRepository.findByHostName(this.hostName)).thenReturn(configAgente);

		configAgente = configAgenteService.createConfig(hostName);
		
		verify(configAgenteRepository, never()).save(Mockito.any());
		Assertions.assertEquals(hash, configAgente.getHash());
		Assertions.assertEquals(3L, configAgente.getTempoEspera());
		Assertions.assertEquals(hostName, configAgente.getHostName());
	}

	@Test
	public void deveRetornarUmConfigAgenteQuandoPassarId() {

		ConfigAgente configAgente = new ConfigAgente.Builder(this.hostName).build();

		when(configAgenteRepository.findById(hash)).thenReturn(Optional.of(configAgente));

		configAgente = configAgenteService.findById(hash);

		Assertions.assertEquals(hash, configAgente.getHash());
		Assertions.assertEquals(3L, configAgente.getTempoEspera(), 3L);
		Assertions.assertEquals(hostName, configAgente.getHostName());
	}

	@Test
	public void deveRetornarUmConfigAgenteQuandoPassarHostName() {

		ConfigAgente configAgente = new ConfigAgente.Builder(this.hostName).build();

		when(configAgenteRepository.findByHostName(this.hostName)).thenReturn(configAgente);

		configAgente = configAgenteService.findByHostName(this.hostName);

		Assertions.assertEquals(hash, configAgente.getHash());
		Assertions.assertEquals(3L, configAgente.getTempoEspera());
		Assertions.assertEquals(hostName, configAgente.getHostName());
	}
}
