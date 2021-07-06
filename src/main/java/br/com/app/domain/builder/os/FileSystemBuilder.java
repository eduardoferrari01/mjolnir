package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.FileSystem;
import br.com.app.util.DomainBuilder;

public class FileSystemBuilder  {

	private ColetaResultado coletaResultado;

	public FileSystemBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public FileSystem builder() {
		FileSystem fileSystem = new DomainBuilder().builder(coletaResultado.getJson(), FileSystem.class);
		fileSystem.setId(coletaResultado.getId());
		return fileSystem;
	}
}