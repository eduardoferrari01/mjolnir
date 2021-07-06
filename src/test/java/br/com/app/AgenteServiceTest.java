package br.com.app;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.app.domain.Agente;
import br.com.app.repository.config.AgenteRepository;
import br.com.app.service.config.AgenteService;

@ExtendWith(MockitoExtension.class)
public class AgenteServiceTest {

	@Mock
	private AgenteRepository agenteRepository;

	@InjectMocks
	private AgenteService agenteService;

	private final String hostName = "meupc";
	private final String hash = "d60079488fed3bbfd189ee5df6bdc000a5e1347296682b15f5e50fdd59112e70";
	private final String alias = "alias";
	private final String sector = "sector";
	
	@Test
	public void deveCriarUmNovoAgenteQuandoHostNameNaoExisti() {

		Agente agente = agenteService.createAgente(hostName);

		Assertions.assertNotNull(agente);
		Assertions.assertEquals(hash, agente.getHash());
		Assertions.assertEquals(3L, agente.getTempoEspera());
		Assertions.assertEquals(hostName, agente.getHostName());
		verify(agenteRepository).save(agente);
	}

	@Test
	public void deveRetornarUmAgenteQuandoHostNameExisti() {

		Agente agente = new Agente.Builder(this.hostName).build();

		when(agenteRepository.findByHostName(this.hostName)).thenReturn(agente);

		agente = agenteService.createAgente(hostName);
		
		verify(agenteRepository, never()).save(Mockito.any());
		Assertions.assertEquals(hash, agente.getHash());
		Assertions.assertEquals(3L, agente.getTempoEspera());
		Assertions.assertEquals(hostName, agente.getHostName());
	}

	@Test
	public void deveRetornarUmAgenteQuandoPassarId() {

		Agente agente = new Agente.Builder(this.hostName).build();

		when(agenteRepository.findById(hash)).thenReturn(Optional.of(agente));

		agente = agenteService.findById(hash);

		Assertions.assertEquals(hash, agente.getHash());
		Assertions.assertEquals(3L, agente.getTempoEspera(), 3L);
		Assertions.assertEquals(hostName, agente.getHostName());
	}

	@Test
	public void deveRetornarUmAgenteQuandoPassarHostName() {

		Agente agente = new Agente.Builder(this.hostName).build();

		when(agenteRepository.findByHostName(this.hostName)).thenReturn(agente);

		agente = agenteService.findByHostName(this.hostName);

		Assertions.assertEquals(hash, agente.getHash());
		Assertions.assertEquals(3L, agente.getTempoEspera());
		Assertions.assertEquals(hostName, agente.getHostName());
	}
	
	@Test
	public void deveAtualizarAgente() {

		when(agenteRepository.findByHostName(this.hostName)).thenReturn(new Agente.Builder(this.hostName).build());

		Agente agenteFind = agenteService.findByHostName(this.hostName);
		
		agenteFind.setAlias(alias);
		agenteFind.setSector(sector);

		agenteService.save(agenteFind);
		
		Agente agenteRetorn = agenteService.findByHostName(this.hostName);
		verify(agenteRepository).save(agenteRetorn);

		Assertions.assertEquals(alias, agenteRetorn.getAlias());
		Assertions.assertEquals(sector, agenteRetorn.getSector());
		 
	}
	
	@Test
	public void deveRetornarUmaListaDeAgentes() {

		final String hostName1 = "pc1";
		final String hostName2 = "pc2";
		
		Agente agente1 = agenteService.createAgente(hostName1);
		Agente agente2 = agenteService.createAgente(hostName2);

		List<Agente> agentesExpected = new ArrayList<>(Arrays.asList(agenteService.createAgente(hostName1),agenteService.createAgente(hostName2)));

		when(agenteRepository.findAll()).thenReturn(new ArrayList<>( Arrays.asList(agente1,agente2)));
		
		List<Agente> agentesActual = agenteService.findAll();
		verify(agenteRepository).findAll();

		Assertions.assertTrue(agentesActual.size() == agentesExpected.size());
		Assertions.assertEquals(agentesActual, agentesExpected);

	}
	
}
