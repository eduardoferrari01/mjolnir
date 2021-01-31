package br.com.app;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import br.com.app.util.GenerateHash;

public class GenerateHashSHA256Test {

	@Test
	public void deveRetornarUmHashValida() throws NoSuchAlgorithmException {
		
		GenerateHash generateHash = new GenerateHash("SHA-256");
		
		assertEquals("4aa6c0e7255c3b89987960d9097b40448079b48e0b51aa3160c486b2da7ff1cd", generateHash.gerar("nomedopc"));
	
	}
	
	@Test
	public void deveRetornarIllegalArgumentExceptionQuandoParametroForNull() {
		
		GenerateHash generateHash = new GenerateHash("SHA-256");
		
		assertThrows(IllegalArgumentException.class, () -> {
			generateHash.gerar(null);
		});
	}
	
	@Test
	public void deveRetornarIllegalArgumentExceptionQuandoParametroForVazio() {
		
		GenerateHash generateHash = new GenerateHash("SHA-256");
		
		assertThrows(IllegalArgumentException.class, () -> {
			generateHash.gerar("");
		});
	}
	
	@Test
	public void deveRetornarIllegalArgumentExceptionQuandoFuncaoHashForInvalida(){
		
		GenerateHash generateHash = new GenerateHash("SHA-000");
		
		assertThrows(IllegalArgumentException.class, () -> {
			generateHash.gerar("nomedopc");
		});
	
	}
	
	@Test
	public void deveRetornarIllegalArgumentExceptionQuandoParametroDoConstrutorForNull(){
		
		assertThrows(IllegalArgumentException.class, () -> {
			new GenerateHash(null);
		});
	}
	
	@Test
	public void deveRetornarIllegalArgumentExceptionQuandoParametroDoConstrutorForVazio(){
		
		assertThrows(IllegalArgumentException.class, () -> {
			new GenerateHash("");
		});
	}

}
