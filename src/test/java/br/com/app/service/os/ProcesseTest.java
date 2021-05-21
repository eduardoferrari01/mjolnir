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
import br.com.app.domain.builder.os.ProcesseBuilder;
import br.com.app.domain.os.OSProcess;
import br.com.app.domain.os.OSProcess.State;
import br.com.app.domain.os.OSThread;
import br.com.app.domain.os.Processe;
import br.com.app.repository.os.ProcesseRepository;
import br.com.app.test.builder.ColetaResultadoTestDataBuilder;
import br.com.app.test.data.loadfile.LoadFileOSJson;

@ExtendWith(MockitoExtension.class)
public class ProcesseTest {

	private static ColetaResultado coletaResultado;
	private static LoadFileOSJson loadFileOSJson;
	@InjectMocks
	private ProcesseService processeService;
	@Mock
	private ProcesseRepository processeRepository;
	
	@BeforeAll
	public static void setup()  {

		loadFileOSJson = new LoadFileOSJson();
		coletaResultado = new ColetaResultadoTestDataBuilder().setJson(loadFileOSJson.loadOSProcess())
				.builder();
	}
	
	@Test
	public void deveSalvarUmProcesse() {

		processeService.save(coletaResultado);
		verify(processeRepository).save(Mockito.any(Processe.class));
	}
	
	@Test
	public void deveConstruirProcesse() {
	
		Processe processe = new ProcesseBuilder(coletaResultado).builder();
		
		Assertions.assertNotNull(processe);
		Assertions.assertEquals(coletaResultado.getId(), processe.getId());
		Assertions.assertNotNull(processe.getOsProcess());
		Assertions.assertFalse(processe.getOsProcess().isEmpty());
		
		OSProcess osProcess = processe.getOsProcess().get(0);
		validateosProcess(osProcess);
		
		OSThread osThread = osProcess.getThreadDetails().get(0);
		validateosThread(osThread); 
		
	}
	
	private void validateosProcess(OSProcess osProcess) {
	
		Assertions.assertNotNull(osProcess);
		Assertions.assertEquals(1, osProcess.getProcessID());
		Assertions.assertEquals(0, osProcess.getBitness());
		Assertions.assertEquals(15, osProcess.getAffinityMask());
		Assertions.assertEquals(0, osProcess.getBytesRead());
		Assertions.assertEquals(0, osProcess.getBytesWritten());
		Assertions.assertEquals(851160, osProcess.getKernelTime());
		Assertions.assertEquals(166, osProcess.getMajorFaults());
		Assertions.assertEquals(13793, osProcess.getMinorFaults());
		Assertions.assertEquals(-1, osProcess.getOpenFiles());
		Assertions.assertEquals(0, osProcess.getParentProcessID());
		Assertions.assertEquals(20, osProcess.getPriority());
		Assertions.assertEquals(0.13826904352110528, osProcess.getProcessCpuLoadCumulative());
		Assertions.assertEquals(11587584, osProcess.getResidentSetSize());
		Assertions.assertEquals(1614434100120L, osProcess.getStartTime());
		Assertions.assertEquals(1, osProcess.getThreadCount());
		Assertions.assertEquals(9547184, osProcess.getUpTime());
		Assertions.assertEquals(468920, osProcess.getUserTime());
		Assertions.assertEquals(175259648, osProcess.getVirtualSize());
		Assertions.assertEquals("sbin0", osProcess.getCommandLine());
		Assertions.assertEquals("", osProcess.getCurrentWorkingDirectory());
		Assertions.assertEquals("root", osProcess.getGroup());
		Assertions.assertEquals("teste1", osProcess.getName());
		Assertions.assertEquals("", osProcess.getPath());
		Assertions.assertEquals(State.NEW, osProcess.getState());
		Assertions.assertEquals("root", osProcess.getUser());
		Assertions.assertEquals("0", osProcess.getUserID());
		Assertions.assertEquals("0", osProcess.getGroupID());
		
		Assertions.assertNotNull(osProcess.getThreadDetails());
		Assertions.assertFalse(osProcess.getThreadDetails().isEmpty());
	}
	
	private void validateosThread(OSThread osThread) {
	
		Assertions.assertEquals(454, osThread.getContextSwitches());
		Assertions.assertEquals(12, osThread.getKernelTime());
		Assertions.assertEquals(2, osThread.getMajorFaults());
		Assertions.assertEquals(3, osThread.getMinorFaults());
		Assertions.assertEquals(111, osThread.getOwningProcessId());
		Assertions.assertEquals(5, osThread.getPriority());
		Assertions.assertEquals(333, osThread.getStartMemoryAddress());
		Assertions.assertEquals(1, osThread.getStartTime());
		Assertions.assertEquals(1.0, osThread.getThreadCpuLoadCumulative());
		Assertions.assertEquals(0, osThread.getThreadId());
		Assertions.assertEquals(1, osThread.getUpTime());
		Assertions.assertEquals(5, osThread.getUserTime());
		Assertions.assertEquals("xxx", osThread.getName());
		Assertions.assertEquals(State.SLEEPING, osThread.getState());
	}
	
}
