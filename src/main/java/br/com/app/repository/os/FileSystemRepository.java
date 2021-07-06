package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.FileSystem;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {

}
