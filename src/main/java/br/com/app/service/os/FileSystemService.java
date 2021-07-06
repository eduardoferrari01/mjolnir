package br.com.app.service.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.builder.os.FileSystemBuilder;
import br.com.app.domain.os.FileSystem;
import br.com.app.repository.os.FileSystemRepository;

@Service
public class FileSystemService {

	@Autowired
	private FileSystemRepository fileSystemRepository;

	public void save(ColetaResultado coletaResultado) {

		FileSystem fileSystem = new FileSystemBuilder(coletaResultado).builder();
		fileSystemRepository.save(fileSystem);
	}
}